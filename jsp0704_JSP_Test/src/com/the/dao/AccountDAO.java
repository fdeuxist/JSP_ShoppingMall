package com.the.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.the.dto.AccountDTO;
import com.the.util.DBConn;

public class AccountDAO {

	public void join(String account_id, String account_pw, 
			String account_name, String account_phone, String account_address) {
		///insert into account values (account_no_counter.nextval, 
		//'admin', 'admin', '관리자', '010-0001-0002', '무슨시 무슨구 무슨동 123-123');
		String sql = "insert into account values (account_no_counter.nextval, '%s', '%s', '%s', '%s', '%s')";
		sql = String.format(sql, 
				account_id, 
				account_pw, 
				account_name, 
				account_phone, 
				account_address);
		DBConn.statementUpdate(sql);
		System.out.println("sql : " + sql);
	}
	
	/*
	 * create table account (
    account_no number,
    account_id nvarchar2(20),
    account_pw nvarchar2(20),
    account_name nvarchar2(20),
    account_phone nvarchar2(20),
    account_addrerss nvarchar2(50));
	 */
	public void update(Integer account_no, String account_id, String account_pw, 
						String account_name, String account_phone, String account_address) {
		String sql = "update account set account_id = '%s', account_pw = '%s', account_name = '%s', account_phone = '%s', account_address = '%s' where account_no = %d";
		sql = String.format(sql, account_id, account_pw, account_name, account_phone, account_address, account_no);
		System.out.println("AccountDAO update sql : " + sql);
		DBConn.statementUpdate(sql);
	}
	
	public void delete(String account_id) {
		String sql = "delete account where account_id = '%s'";
		sql = String.format(sql, account_id);
		DBConn.statementUpdate(sql);
	}
	
	public AccountDTO selectOne(Integer account_no) {
		AccountDTO dto = new AccountDTO();
		ResultSet rs = DBConn.statementQuery("select * from account where account_no = " + account_no);

		try {
			while(rs.next()) {
				dto = new AccountDTO(
						rs.getInt("account_no"),
						rs.getString("account_id"),
						rs.getString("account_pw"),
						rs.getString("account_name"),
						rs.getString("account_phone"),
						rs.getString("account_address")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	public AccountDTO selectOne(String account_id) {
		AccountDTO dto = new AccountDTO();
		ResultSet rs = DBConn.statementQuery("select * from account where account_id in '" + account_id + "'");

		try {
			while(rs.next()) {
				dto = new AccountDTO(
						rs.getInt("account_no"),
						rs.getString("account_id"),
						rs.getString("account_pw"),
						rs.getString("account_name"),
						rs.getString("account_phone"),
						rs.getString("account_address")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	public AccountDTO login(String account_id, String account_pw) {
		AccountDTO dto = null;
		String sql = "select * from account where account_id in '%s' and account_pw in '%s'";
		sql = String.format(sql, account_id, account_pw);
		//System.out.println("sql : " + sql);
		ResultSet rs = DBConn.statementQuery(sql);
		
		try {
			if(rs.next()) {
				dto = new AccountDTO(
					rs.getInt("account_no"),
					rs.getString("account_id"),
					rs.getString("account_pw"),
					rs.getString("account_name"),
					rs.getString("account_phone"),
					rs.getString("account_address")
					);
				System.out.println("id: " + rs.getString("account_id") + ", login " );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
}
