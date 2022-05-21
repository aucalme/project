package com.itwill.command;

public class CartVO {

	private String userId;
	private int pno;
	private int quantity;
	private int price;
	private String p_imgAddr;
	private String pName;

	public CartVO() {
		// TODO Auto-generated constructor stub
	}

	public CartVO(String userId, int pno, int quantity, int price, String p_imgAddr, String pName) {
		this.userId = userId;
		this.pno = pno;
		this.quantity = quantity;
		this.price = price;
		this.p_imgAddr = p_imgAddr;
		this.pName = pName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getP_imgAddr() {
		return p_imgAddr;
	}

	public void setP_imgAddr(String p_imgAddr) {
		this.p_imgAddr = p_imgAddr;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Override
	public String toString() {
		return "CartVO [userId=" + userId + ", pno=" + pno + ", quantity=" + quantity + ", price=" + price
				+ ", p_imgAddr=" + p_imgAddr + ", pName=" + pName + "]";
	}

}
