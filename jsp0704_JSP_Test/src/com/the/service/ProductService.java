package com.the.service;

import java.util.ArrayList;

import com.the.dao.ProductDAO;
import com.the.dto.ProductDTO;

public class ProductService {

	ProductDAO pdao = new ProductDAO();
	
	public void insert(String pdt_name, Integer pdt_cost, String pdt_imgpath) {
		pdao.insert(pdt_name, pdt_cost, pdt_imgpath);
	}
	
	public void update(Integer pdt_no, String pdt_name, Integer pdt_cost, String pdt_imgpath) {
		pdao.update(pdt_no, pdt_name, pdt_cost, pdt_imgpath);
	}
	
	public void delete(Integer pdt_no) {
		pdao.delete(pdt_no);
	}
	
	public ArrayList<ProductDTO> selectAll() {
		ArrayList<ProductDTO> pDtos = pdao.selectAll();
		return pDtos;
	}
	

	public ProductDTO selectOne(Integer pdt_no) {
		ProductDTO pDto = pdao.selectOne(pdt_no);
		return pDto;
	}
	
	
}
