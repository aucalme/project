package com.itwill.command;

import java.util.Date;

public class AgeChartVO {

	private int pno;
	private String userId;
	private Date birth;
	private String gender;

	public AgeChartVO() {
		// TODO Auto-generated constructor stub
	}

	public AgeChartVO(int pno, String userId, Date birth, String gender) {
		this.pno = pno;
		this.userId = userId;
		this.birth = birth;
		this.gender = gender;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
