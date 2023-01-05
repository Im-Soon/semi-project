package kr.cart.vo;

import java.util.Date;

//import kr.product.vo.ProductVO;

public class CartVO {
	private int cart_num;
	private int pro_num;
	private int cart_count;
	private int mem_num;
	private int sub_total;
	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}
	public int getPro_num() {
		return pro_num;
	}
	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getSub_total() {
		return sub_total;
	}
	public void setSub_total(int sub_total) {
		this.sub_total = sub_total;
	}
	
	//private ProductVO productVo;

	

	/*
	 * public ProductVO getProductVO() { return ProductVO; }
	 * 
	 * public void setItemVo(ProductVO productVo) { this.ProductVO = productVo; }
	 */
}
