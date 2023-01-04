package kr.notice.vo;

import java.sql.Date;

public class NoticeVO {
	private int noti_num;
	private String noti_title;
	private String noti_content;
	private String noti_file;
	private int noti_hit;
	private Date noti_reg_date;
	
	public int getNoti_num() {
		return noti_num;
	}
	
	public void setNoti_num(int noti_num) {
		this.noti_num = noti_num;
	}
	
	public String getNoti_title() {
		return noti_title;
	}
	
	public void setNoti_title(String noti_title) {
		this.noti_title = noti_title;
	}
	
	public String getNoti_content() {
		return noti_content;
	}
	
	public void setNoti_content(String noti_content) {
		this.noti_content = noti_content;
	}
	
	public String getNoti_file() {
		return noti_file;
	}
	
	public void setNoti_file(String noti_file) {
		this.noti_file = noti_file;
	}
	
	public int getNoti_hit() {
		return noti_hit;
	}
	
	public void setNoti_hit(int noti_hit) {
		this.noti_hit = noti_hit;
	}
	
	public Date getNoti_reg_date() {
		return noti_reg_date;
	}
	
	public void setNoti_reg_date(Date noti_reg_date) {
		this.noti_reg_date = noti_reg_date;
	}	
}
