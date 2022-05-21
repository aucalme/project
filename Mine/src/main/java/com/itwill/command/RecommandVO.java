package com.itwill.command;

import java.util.Date;

public class RecommandVO {

	private int pno;
	private String gender;
	private int height;
	private int weight;
	private String reviews;
	private String pSize;
	private Date regdate;
	private String recommandDate;
	
	public RecommandVO() {
		// TODO Auto-generated constructor stub
	}

	public RecommandVO(int pno, String gender, int height, int weight, String reviews, String pSize, Date regdate,
			String recommandDate) {
		super();
		this.pno = pno;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.reviews = reviews;
		this.pSize = pSize;
		this.regdate = regdate;
		this.recommandDate = recommandDate;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getRecommandDate() {
		return recommandDate;
	}

	public void setRecommandDate(String recommandDate) {
		this.recommandDate = recommandDate;
	}

	@Override
	public String toString() {
		return "RecommandVO [pno=" + pno + ", gender=" + gender + ", height=" + height + ", weight=" + weight
				+ ", reviews=" + reviews + ", pSize=" + pSize + ", regdate=" + regdate + ", recommandDate="
				+ recommandDate + "]";
	}

	
	
	
	
}

