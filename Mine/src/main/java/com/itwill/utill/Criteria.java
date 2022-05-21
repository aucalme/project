package com.itwill.utill;

import java.util.List;
import java.util.Map;

public class Criteria {

	
	// 현재 페이지
	private int pageNum;
	
	// 페이지네이션 갯수
	private int amount; 
	
	private String category;
	private Map<String, List<String>> checkObj;
	private String searchName;

	public Criteria() {
		this(1,8);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


	
	

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Map<String, List<String>> getCheckObj() {
		return checkObj;
	}

	public void setCheckObj(Map<String, List<String>> checkObj) {
		this.checkObj = checkObj;
	}
	
	
}
