package com.itwill.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.chart.service.ChartService;

@Controller
@RequestMapping({"/chart","/board"})
public class ChartController {

	
	@Autowired
	@Qualifier("chartService")
	ChartService chartService;
	
	@ResponseBody
	@RequestMapping("/chartList")
	public ArrayList<Integer> chartList(@RequestParam("pno")int pno){
		
		
		System.out.println("왜 못찾냐");
		int age18=chartService.age18(pno);
		int age23=chartService.age23(pno);
		int age28=chartService.age28(pno);
		int age33=chartService.age33(pno);
		int age39=chartService.age39(pno);
		int age40=chartService.age40(pno);
		
		ArrayList<Integer> list= new ArrayList<Integer>();
		
		list.add(age18);
		list.add(age23);
		list.add(age28);
		list.add(age33);
		list.add(age39);
		list.add(age40);
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/genderList")
	public ArrayList<Integer> genderList(@RequestParam("pno") int pno){
		
		ArrayList<Integer> list=new ArrayList();
		int male=chartService.male(pno);
		int female=chartService.female(pno);
	
		
		list.add(male);
		list.add(female);
		System.out.println(male);
		System.out.println(female);
		System.out.println(list);
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/sellCount")
	public int sellCount(@RequestParam("pno")int pno) {
		
		int result= chartService.sellCount(pno);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/recommandReviews")
	public int recommandReviews(@RequestParam("pno")int pno) {
		int result = chartService.recommandReviews(pno);
		return result;
	}

}
