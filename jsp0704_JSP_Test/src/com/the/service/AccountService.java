package com.the.service;

import com.the.dao.AccountDAO;
import com.the.dto.AccountDTO;

public class AccountService {
	AccountDAO adao = new AccountDAO();
	/*
	 * create table account (
    account_no number,
    account_id nvarchar2(20),
    account_pw nvarchar2(20),
    account_name nvarchar2(20),
    account_phone nvarchar2(20),
    account_addrerss nvarchar2(50));
	 */
	public void join(String account_id, String account_pw, 
			String account_name, String account_phone, String account_address) {
		adao.join(account_id, account_pw, 
				account_name, account_phone, account_address);
	}
	
	public void update(Integer account_no, String account_id, String account_pw, 
						String account_name, String account_phone, String account_address) {
		adao.update(account_no, account_id, account_pw, 
				account_name, account_phone, account_address);
	}
	
	public void delete(String account_id) {
		adao.delete(account_id);
	}
	
	public AccountDTO selectOne(Integer account_no) {
		AccountDTO dto = adao.selectOne(account_no);
		return dto;
	}
	
	public AccountDTO selectOne(String account_id) {
		AccountDTO dto = adao.selectOne(account_id);
		return dto;
	}
	
	public AccountDTO login(String account_id, String account_pw) {
		AccountDTO dto = adao.login(account_id, account_pw);
		return dto;
	}
	
	
}
