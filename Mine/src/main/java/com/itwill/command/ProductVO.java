package com.itwill.command;

public class ProductVO {


	private int pno;
	private String pCategory;
	private String pName;
	private String pTitle;
	private String pBrand;
	private String uniqueName;
	private String price;
	private String pDetail;
	private String p_imgAddr;
	private String regdate;
	private int views;
	private int pLike;
	
	
	public ProductVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductVO(int pno, String pCategory, String pName, String pTitle, String pBrand, String uniqueName,
			String price, String pDetail, String p_imgAddr, String regdate, int views, int pLike) {
		super();
		this.pno = pno;
		this.pCategory = pCategory;
		this.pName = pName;
		this.pTitle = pTitle;
		this.pBrand = pBrand;
		this.uniqueName = uniqueName;
		this.price = price;
		this.pDetail = pDetail;
		this.p_imgAddr = p_imgAddr;
		this.regdate = regdate;
		this.views = views;
		this.pLike = pLike;
	}
	
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getpCategory() {
		return pCategory;
	}
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public String getUniqueName() {
		return uniqueName;
	}
	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getpDetail() {
		return pDetail;
	}
	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}
	public String getP_imgAddr() {
		return p_imgAddr;
	}
	public void setP_imgAddr(String p_imgAddr) {
		this.p_imgAddr = p_imgAddr;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getpLike() {
		return pLike;
	}
	public void setpLike(int pLike) {
		this.pLike = pLike;
	}

	@Override
	public String toString() {
		return "ProductVO [pno=" + pno + ", pCategory=" + pCategory + ", pName=" + pName + ", pTitle=" + pTitle
				+ ", pBrand=" + pBrand + ", uniqueName=" + uniqueName + ", price=" + price + ", pDetail=" + pDetail
				+ ", p_imgAddr=" + p_imgAddr + ", regdate=" + regdate + ", views=" + views + ", pLike=" + pLike + "]";
	}
	
	

	
	
}
	