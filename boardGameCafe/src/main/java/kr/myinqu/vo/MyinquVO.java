package kr.myinqu.vo;

import java.sql.Date;

public class MyinquVO {
	private int inqu_num;
	private String inqu_title;
	private String inqu_content;
	private int inqu_hit;
	private Date inqu_reg_date;
	private String inqu_file;
	private int mem_num;
	private int inqu_check;
	//private String ip;
	private String mem_id;
	private String mem_photo;
	public int getInqu_num() {
		return inqu_num;
	}
	public void setInqu_num(int inqu_num) {
		this.inqu_num = inqu_num;
	}
	public String getInqu_title() {
		return inqu_title;
	}
	public void setInqu_title(String inqu_title) {
		this.inqu_title = inqu_title;
	}
	public String getInqu_content() {
		return inqu_content;
	}
	public void setInqu_content(String inqu_content) {
		this.inqu_content = inqu_content;
	}
	public int getInqu_hit() {
		return inqu_hit;
	}
	public void setInqu_hit(int inqu_hit) {
		this.inqu_hit = inqu_hit;
	}
	public Date getInqu_reg_date() {
		return inqu_reg_date;
	}
	public void setInqu_reg_date(Date inqu_reg_date) {
		this.inqu_reg_date = inqu_reg_date;
	}
	public String getInqu_file() {
		return inqu_file;
	}
	public void setInqu_file(String inqu_file) {
		this.inqu_file = inqu_file;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getInqu_check() {
		return inqu_check;
	}
	public void setInqu_check(int inqu_check) {
		this.inqu_check = inqu_check;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_photo() {
		return mem_photo;
	}
	public void setMem_photo(String mem_photo) {
		this.mem_photo = mem_photo;
	}
	
	
	
}
