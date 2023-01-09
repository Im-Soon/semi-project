package kr.myorder.vo;

import java.sql.Date;

public class MyOrderVO {
	
	private int mem_num;
	private String pro_name;
	private int order_main_total;
	private Date order_main_date;
	private int order_main_num;
	
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getOrder_main_total() {
		return order_main_total;
	}
	public void setOrder_main_total(int order_main_total) {
		this.order_main_total = order_main_total;
	}
	public Date getOrder_main_date() {
		return order_main_date;
	}
	public void setOrder_main_date(Date order_main_date) {
		this.order_main_date = order_main_date;
	}
	public int getOrder_main_num() {
		return order_main_num;
	}
	public void setOrder_main_num(int order_main_num) {
		this.order_main_num = order_main_num;
	}
	
	
	
	
}
