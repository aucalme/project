package com.itwill.command;




public class UserVO {

	private String userId;
	private String userPw;
	private String gender;
	private String userName;
	private String userPhone;
	private String userEmail;
	private int userZipCode;
	private String userAddr;
	private String userAddrDetail;
	private String userBirth;
	
	
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}


	public UserVO(String userId, String userPw, String gender, String userName, String userPhone, String userEmail,
			int userZipCode, String userAddr, String userAddrDetail, String userBirth) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.gender = gender;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userZipCode = userZipCode;
		this.userAddr = userAddr;
		this.userAddrDetail = userAddrDetail;
		this.userBirth = userBirth;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public int getUserZipCode() {
		return userZipCode;
	}


	public void setUserZipCode(int userZipCode) {
		this.userZipCode = userZipCode;
	}


	public String getUserAddr() {
		return userAddr;
	}


	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}


	public String getUserAddrDetail() {
		return userAddrDetail;
	}


	public void setUserAddrDetail(String userAddrDetail) {
		this.userAddrDetail = userAddrDetail;
	}


	public String getUserBirth() {
		return userBirth;
	}


	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}


	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", gender=" + gender + ", userName=" + userName
				+ ", userPhone=" + userPhone + ", userEmail=" + userEmail + ", userZipCode=" + userZipCode
				+ ", userAddr=" + userAddr + ", userAddrDetail=" + userAddrDetail + ", userBirth=" + userBirth + "]";
	}
	
	
	
	
	
	
	
}
