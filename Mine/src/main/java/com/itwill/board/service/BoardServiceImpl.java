package com.itwill.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.board.mapper.BoardMapper;
import com.itwill.command.ProductVO;
import com.itwill.command.RecommandVO;
import com.itwill.utill.Criteria;
import com.itwill.utill.PageVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getTotal(cri);
	}

	@Override
	public ArrayList<ProductVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getList(cri);
	}

	@Override
	public ProductVO detail(int pno) {
		// TODO Auto-generated method stub
		return boardMapper.detail(pno);
	}

	@Override
	public void viewsUpdate(int pno) {
		boardMapper.viewsUpdate(pno);
	}

	@Override
	public ProductVO cartProduct(int pno) {
		// TODO Auto-generated method stub
		return boardMapper.cartProduct(pno);
	}

	@Override
	public int recommandInsert(RecommandVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.recommandInsert(vo);
	}
	
	@Override
	public ArrayList<RecommandVO> getRecommandList() {
		// TODO Auto-generated method stub
		return boardMapper.getRecommandList();
	}
}
