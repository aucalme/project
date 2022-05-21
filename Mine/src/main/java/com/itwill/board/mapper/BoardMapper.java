package com.itwill.board.mapper;

import java.util.ArrayList;

import com.itwill.command.ProductVO;
import com.itwill.command.RecommandVO;
import com.itwill.utill.Criteria;

public interface BoardMapper {

	public int getTotal(Criteria cri);
	
	public ArrayList<ProductVO> getList(Criteria cri);
	public ProductVO detail(int pno);
	public void viewsUpdate(int pno);
	public ProductVO cartProduct(int pno);
	public int recommandInsert(RecommandVO vo);
	public ArrayList<RecommandVO> getRecommandList();
	
}
