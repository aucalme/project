package com.itwill.command;

public class AdminVO {

	private String adminId;
	private String adminPw;
	private String email;
	private int auth;
	
	 
	public AdminVO() {
		// TODO Auto-generated constructor stub
	}

	
	

	public AdminVO(String adminId, String adminPw, String email, int auth) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.email = email;
		this.auth = auth;
	}




	public String getAdminId() {
		return adminId;
	}


	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}


	public String getAdminPw() {
		return adminPw;
	}


	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAuth() {
		return auth;
	}


	public void setAuth(int auth) {
		this.auth = auth;
	}
	
	
	
	
}
