package kr.reserve.vo;

import java.sql.Date;
 
public class ReserveVO {
	private int res_num;
	private int mem_num;
	private String res_date;
	private String res_time;
	private int res_count;
	private int room_num;
	
	public int getRes_num() {
		return res_num;
	}
	public void setRes_num(int res_num) {
		this.res_num = res_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public String getRes_time() {
		return res_time;
	}
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}
	public int getRes_count() {
		return res_count;
	}
	public void setRes_count(int res_count) {
		this.res_count = res_count;
	}
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}
	
}
