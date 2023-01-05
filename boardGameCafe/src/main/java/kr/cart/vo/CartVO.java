package kr.cart.vo;

import java.util.Date;

//import kr.product.vo.ProductVO;

public class CartVO {
	private int cart_num;
	private int item_num;
	private int order_quantity;
	private Date reg_date;
	private int mem_num;
	private int sub_total;
	
	//private ProductVO productVo;

	public int getCart_num() {
		return cart_num;
	}

	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}

	public int getItem_num() {
		return item_num;
	}

	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}

	public int getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(int oreder_quantity) {
		this.order_quantity = oreder_quantity;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
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

	/*
	 * public ProductVO getProductVO() { return ProductVO; }
	 * 
	 * public void setItemVo(ProductVO productVo) { this.ProductVO = productVo; }
	 */
}
