package com.itwill.admin.mapper;

import java.util.ArrayList;


import com.itwill.command.AdminVO;
import com.itwill.command.ProductVO;
import com.itwill.utill.AdminCriteria;

public interface AdminMapper {

	

	public int insert(ProductVO vo);

	public ArrayList<ProductVO> getProductList();
	public int delete(ArrayList<String> pno);
	public ArrayList<ProductVO> getImgAddr(ArrayList<String> pno);
	public ArrayList<ProductVO> getFilteredList(AdminCriteria cri);
	public AdminVO checkAdmin(AdminVO vo);
	public void authNum(String ranNum);
	public int update(ProductVO vo);
	
	public String selectEmail();
	public String selectAuth();

}
