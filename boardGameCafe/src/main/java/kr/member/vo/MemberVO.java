package kr.member.vo;

import java.sql.Date;

public class MemberVO {
	private int mem_num;
	private String mem_id;
	private int mem_auth;
	private String mem_name;
	private String mem_pw;
	private String mem_email;
	private String mem_phone;
	private String mem_zipcode;
	private String mem_address1;
	private String mem_address2;
	private String mem_photo;
	private Date mem_reg;
	private Date mem_modify;
	
	public boolean isCheckedPassword(String usermem_pw) {
		if(mem_auth > 1 && mem_pw.equals(usermem_pw)) {
			return true;
		}
		
		return false; 
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getMem_auth() {
		return mem_auth;
	}

	public void setMem_auth(int mem_auth) {
		this.mem_auth = mem_auth;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_zipcode() {
		return mem_zipcode;
	}

	public void setMem_zipcode(String mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}

	public String getMem_address1() {
		return mem_address1;
	}

	public void setMem_address1(String mem_address1) {
		this.mem_address1 = mem_address1;
	}

	public String getMem_address2() {
		return mem_address2;
	}

	public void setMem_address2(String mem_address2) {
		this.mem_address2 = mem_address2;
	}

	public String getMem_photo() {
		return mem_photo;
	}

	public void setMem_photo(String mem_photo) {
		this.mem_photo = mem_photo;
	}

	public Date getMem_reg() {
		return mem_reg;
	}

	public void setMem_reg(Date mem_reg) {
		this.mem_reg = mem_reg;
	}

	public Date getMem_modify() { 
		return mem_modify;
	}

	public void setMem_modify(Date mem_modify) {
		this.mem_modify = mem_modify;
	}
}
 