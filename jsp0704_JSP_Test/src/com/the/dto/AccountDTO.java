package com.the.dto;
/*
create table account (
    account_no number,
    account_id nvarchar2(20),
    account_pw nvarchar2(20),
    account_name nvarchar2(20),
    account_phone nvarchar2(20),
    account_addrerss nvarchar2(50));

insert into account values ( account_no_counter.nextval, 'admin', 'admin', '관리자', '010-0001-0002', '무슨시 무슨구 무슨동 123-123');
insert into account values ( account_no_counter.nextval, 'user1', 'user1', '사용자1', '010-1111-2222', '무슨시 무슨구 무슨동 111-11');
insert into account values ( account_no_counter.nextval, 'user2', 'user2', '사용자2', '010-2222-3333', '무슨시 무슨구 무슨동 222-22');
 */
public class AccountDTO {
	Integer account_no;
	String account_id;
	String account_pw;
	String account_name;
	String account_phone;
	String account_address;
	
	

	public AccountDTO() {}
	
	public AccountDTO(Integer account_no, String account_id, String account_pw, String account_name, String account_phone,
			String account_address) {
		super();
		this.account_no = account_no;
		this.account_id = account_id;
		this.account_pw = account_pw;
		this.account_name = account_name;
		this.account_phone = account_phone;
		this.account_address = account_address;
	}

	public Integer getAccount_no() {
		return account_no;
	}
	public void setAccount_no(Integer account_no) {
		this.account_no = account_no;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getAccount_pw() {
		return account_pw;
	}
	public void setAccount_pw(String account_pw) {
		this.account_pw = account_pw;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_phone() {
		return account_phone;
	}
	public void setAccount_phone(String account_phone) {
		this.account_phone = account_phone;
	}
	public String getAccount_address() {
		return account_address;
	}
	public void setAccount_address(String account_address) {
		this.account_address = account_address;
	}

	@Override
	public String toString() {
		return "AccountDTO [account_no=" + account_no + ", account_id=" + account_id + ", account_pw=" + account_pw + ", account_name=" + account_name
				+ ", account_phone=" + account_phone + ", account_address=" + account_address + "]";
	}
	
	
	
	
}
