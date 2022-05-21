package com.itwill.chart.mapper;

import com.itwill.command.AgeChartVO;

public interface ChartMapper {

	public int age18(int pno);
	public int age23(int pno);
	public int age28(int pno);
	public int age33(int pno);
	public int age39(int pno);
	public int age40(int pno);
	public int ageChartInsert(AgeChartVO vo);
	public int male(int pno);
	public int female(int pno);
	public int sellCount(int pno);
	public int recommandReviews(int pno);
}
