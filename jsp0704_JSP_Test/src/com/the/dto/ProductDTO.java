package com.the.dto;

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
public class ProductDTO {
	Integer pdt_no;
	String pdt_name;
	Integer pdt_cost;
	String pdt_imgpath;
	

	public ProductDTO() {}

	public ProductDTO(Integer pdt_no, String pdt_name, Integer pdt_cost) {
		super();
		this.pdt_no = pdt_no;
		this.pdt_name = pdt_name;
		this.pdt_cost = pdt_cost;
	}
	public ProductDTO(Integer pdt_no, String pdt_name, Integer pdt_cost, String pdt_imgpath) {
		super();
		this.pdt_no = pdt_no;
		this.pdt_name = pdt_name;
		this.pdt_cost = pdt_cost;
		this.pdt_imgpath = pdt_imgpath;
	}
	public Integer getPdt_no() {
		return pdt_no;
	}
	public void setPdt_no(Integer pdt_no) {
		this.pdt_no = pdt_no;
	}
	public String getPdt_name() {
		return pdt_name;
	}
	public void setPdt_name(String pdt_name) {
		this.pdt_name = pdt_name;
	}
	public Integer getPdt_cost() {
		return pdt_cost;
	}
	public void setPdt_cost(Integer pdt_cost) {
		this.pdt_cost = pdt_cost;
	}
	public String getPdt_imgpath() {
		return pdt_imgpath;
	}
	public void setPdt_imgpath(String pdt_imgpath) {
		this.pdt_imgpath = pdt_imgpath;
	}

	@Override
	public String toString() {
		return "ProductDTO [pdt_no=" + pdt_no  + ", pdt_name=" + pdt_name + ", pdt_cost=" + pdt_cost + ", pdt_imgpath=" + pdt_imgpath + "]";
	}
	
	
}
