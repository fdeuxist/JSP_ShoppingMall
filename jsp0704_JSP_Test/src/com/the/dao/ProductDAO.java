package com.the.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.the.dto.ProductDTO;
import com.the.util.DBConn;

public class ProductDAO {

/*
create table product (
    pdt_no number,
    pdt_name nvarchar2(20),
    pdt_cost number(10),
    pdt_imgpath nvarchar2(50));

insert into product values( pdt_no_counter.nextval, '콜라', 1200, '\cola.png');
insert into product values( pdt_no_counter.nextval, '사이다', 1100, '\cider.png');
insert into product values( pdt_no_counter.nextval, '환타', 1000, '\fanta.png');
insert into product values( pdt_no_counter.nextval, '커피', 400, '\coffee.png');

 */
	
	public void insert(String pdt_name, Integer pdt_cost, String pdt_imgpath) {
		String sql = "insert into product values ( pdt_no_counter.nextval, '%s', %d, '%s')";
		sql = String.format(sql, pdt_name, pdt_cost, pdt_imgpath);
		DBConn.statementUpdate(sql);
		System.out.println("sql : " + sql);
	}
	
	public void update(Integer pdt_no, String pdt_name, Integer pdt_cost, String pdt_imgpath) {
		String sql = "update account set pdt_name = '%s', pdt_cost = %d, pdt_imgpath = '%s' where pdt_no = %d";
		sql = String.format(pdt_name, pdt_cost, pdt_imgpath, pdt_no);
		DBConn.statementUpdate(sql);
	}
	
	public void delete(Integer pdt_no) {
		String sql = "delete product where pdt_no = %d";
		sql =  String.format(sql, pdt_no);
		DBConn.statementUpdate(sql);
		
	}
	
	public ArrayList<ProductDTO> selectAll() {
		ArrayList<ProductDTO> pDtos = new ArrayList<ProductDTO>();
		ResultSet rs = DBConn.statementQuery("select * from product order by pdt_no");

		try {
			while(rs.next()) {
				pDtos.add(new ProductDTO(
						rs.getInt("pdt_no"),
						rs.getString("pdt_name"),
						rs.getInt("pdt_cost"),
						rs.getString("pdt_imgpath")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pDtos;
	}

	public ProductDTO selectOne(Integer pdt_no) {
		ProductDTO pDto = new ProductDTO();
		ResultSet rs = DBConn.statementQuery("select * from product where pdt_no =" + pdt_no);
		try {
			if(rs.next()) {
				pDto.setPdt_no(rs.getInt("pdt_no"));
				pDto.setPdt_name(rs.getString("pdt_name"));
				pDto.setPdt_cost(rs.getInt("pdt_cost"));
				pDto.setPdt_imgpath(rs.getString("pdt_imgpath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pDto;
	}
	
	
	
}
