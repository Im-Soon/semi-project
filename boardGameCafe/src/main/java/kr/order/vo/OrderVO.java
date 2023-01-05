package kr.order.vo;

import java.sql.Date;

public class OrderVO {
	//order_main
	private int order_main_num;
	private int mem_num;
	private String order_main_name;
	private int order_main_total;
	private int payment;
	private Date order_main_date;
	private String mem_zipcode;	
	private String mem_address1;	
	private String mem_address2;	
	private String mem_phone;	
	
	//order_detail
	private int order_detail_num;
	private String pro_name;  
	private int pro_price;
	private int pro_total;
	private int pro_quantity;
	private int status;
	
	
	public int getOrder_main_num() {
		return order_main_num;
	}
	public void setOrder_main_num(int order_main_num) {
		this.order_main_num = order_main_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getOrder_main_name() {
		return order_main_name;
	}
	public void setOrder_main_name(String order_main_name) {
		this.order_main_name = order_main_name;
	}
	public int getOrder_main_total() {
		return order_main_total;
	}
	public void setOrder_main_total(int order_main_total) {
		this.order_main_total = order_main_total;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public Date getOrder_main_date() {
		return order_main_date;
	}
	public void setOrder_main_date(Date order_main_date) {
		this.order_main_date = order_main_date;
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
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public int getOrder_detail_num() {
		return order_detail_num;
	}
	public void setOrder_detail_num(int order_detail_num) {
		this.order_detail_num = order_detail_num;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public int getPro_total() {
		return pro_total;
	}
	public void setPro_total(int pro_total) {
		this.pro_total = pro_total;
	}
	public int getPro_quantity() {
		return pro_quantity;
	}
	public void setPro_quantity(int pro_quantity) {
		this.pro_quantity = pro_quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

	
	
}
