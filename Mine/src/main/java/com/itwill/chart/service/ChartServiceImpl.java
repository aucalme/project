package com.itwill.chart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.chart.mapper.ChartMapper;
import com.itwill.command.AgeChartVO;

@Service("chartService")
public class ChartServiceImpl implements ChartService{
	
	@Autowired
	private ChartMapper chartMapper;

	@Override
	public int age18(int pno) {
		// TODO Auto-generated method stub
		return chartMapper.age18(pno);
	}

	@Override
	public int age23(int pno) {
		// TODO Auto-generated method stub
		return chartMapper.age23(pno);
	}

	@Override
	public int age28(int pno) {
		// TODO Auto-generated method stub
		return chartMapper.age28(pno);
	}

	@Override
	public int age33(int pno) {
		// TODO Auto-generated method stub
		return chartMapper.age33(pno);
	}

	@Override
	public int age39(int pno) {
		// TODO Auto-generated method stub
		return chartMapper.age39(pno);
	}

	@Override
	public int age40(int pno) {
		// TODO Auto-generated method stub
		return chartMapper.age40(pno);
	}
	
	@Override
	public int ageChartInsert(AgeChartVO vo) {
		// TODO Auto-generated method stub
		return chartMapper.ageChartInsert(vo);
	}

	@Override
	public int female(int pno) {
		// TODO Auto-generated method stub
		return chartMapper.female(pno);
	}
	@Override
	public int male(int pno) {
		// TODO Auto-generated method stub
		return chartMapper.male(pno);
	}
	
	@Override
	public int sellCount(int pno) {
		// TODO Auto-generated method stub
		return chartMapper.sellCount(pno);
	}
	@Override
	public int recommandReviews(int pno) {
		// TODO Auto-generated method stub
		return chartMapper.recommandReviews(pno);
	}
	
}
