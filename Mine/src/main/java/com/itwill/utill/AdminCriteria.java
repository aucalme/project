package com.itwill.utill;

import java.util.ArrayList;

public class AdminCriteria {

	private ArrayList<String> category;
	
	
	private int maxPrice;
	private int minPrice;


	private String searchType;
	private String searchWord;
	

	public AdminCriteria() {
		// TODO Auto-generated constructor stub
	}


	public AdminCriteria(int maxPrice, int minPrice) {
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;


	}

	public ArrayList<String> getCategory() {
		return category;
	}

	public void setCategory(ArrayList<String> category) {
		this.category = category;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}


	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	

	
	
}
