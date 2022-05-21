package com.itwill.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.admin.mapper.AdminMapper;
import com.itwill.command.AdminVO;
import com.itwill.command.ProductVO;
import com.itwill.utill.AdminCriteria;


@Service("adminService")
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	private AdminMapper adminMapper;
	
	
	@Override

	public int insert(ProductVO vo) {


		return adminMapper.insert(vo);
	}
	
	@Override
	public ArrayList<ProductVO> getProductList() {
		// TODO Auto-generated method stub
		return adminMapper.getProductList();
	}
	@Override
	public int delete(ArrayList<String> pno) {
		// TODO Auto-generated method stub
		return adminMapper.delete(pno);
	}

	@Override
	public ArrayList<ProductVO> getImgAddr(ArrayList<String> pno) {
		
		return adminMapper.getImgAddr(pno);
	}
	@Override
	public ArrayList<ProductVO> getFilteredList(AdminCriteria cri) {
		// TODO Auto-generated method stub
		return adminMapper.getFilteredList(cri);
	}
	
	@Override
	public AdminVO checkAdmin(AdminVO vo) {
		
		return adminMapper.checkAdmin(vo);
	}
	
	@Override
	public void authNum(String ranNum) {
		adminMapper.authNum(ranNum);
		
	}
	@Override
	public String selectEmail() {
		// TODO Auto-generated method stub
		return adminMapper.selectEmail();
	}
	
	@Override
	public String selectAuth() {
		// TODO Auto-generated method stub
		return adminMapper.selectAuth();
	}
	@Override
	public int update(ProductVO vo) {
		// TODO Auto-generated method stub
		return adminMapper.update(vo);
	}



}
