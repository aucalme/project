package com.itwill.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.board.service.BoardService;
import com.itwill.chart.service.ChartService;
import com.itwill.command.AgeChartVO;
import com.itwill.command.ProductVO;
import com.itwill.command.RecommandVO;
import com.itwill.command.UserVO;
import com.itwill.utill.Criteria;
import com.itwill.utill.PageVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	@Autowired
	@Qualifier("chartService")
	ChartService chartService;
	
	
	@ResponseBody
	@GetMapping("/getList")
	public HashMap<String, Object> getList(@RequestParam("pageNum") int pageNum,
										    @RequestParam("category")String category,
										    @RequestParam(value="searchName", required=false) String searchName){
		
		
		System.out.println(searchName);
		Criteria cri = new Criteria(pageNum, 8);
		cri.setCategory(category);
		cri.setSearchName(searchName);
		
		int total= boardService.getTotal(cri);
		System.out.println(total+" total");
		PageVO pageVO=new PageVO(cri, total);
		ArrayList<ProductVO> list = boardService.getList(cri);
		
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", list);
		map.put("pageVO", pageVO);
		
		return map;
		
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(@RequestParam("pno") int pno, Model model) {
		
		System.out.println(pno);
		ProductVO vo=boardService.detail(pno);
		boardService.viewsUpdate(pno);
		
		model.addAttribute("ProductVO", vo);
		
		return "product/detail";
	}
	
	@RequestMapping("/paymentPage")
	public String paymentPage(@RequestParam("pno")int pno, Model model) {
		
		ProductVO vo=boardService.cartProduct(pno);
		System.out.println("payment ProductVO =" + vo);
		model.addAttribute("ProductVO", vo);
		
		return "product/payment";
	}
	
	@RequestMapping("/payment")
	public String payment(@RequestParam("pno")int pno,HttpServletRequest request, RedirectAttributes rd) throws ParseException {
		
		HttpSession session=request.getSession();
		
		UserVO vo=(UserVO)session.getAttribute("loginUserId");
		AgeChartVO ageVO=new AgeChartVO();
		
		String from=vo.getUserBirth();
		String userBirth=from.replace("-", "/");
		
		System.out.println("String userBirth = " + userBirth);
	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		
		Date endDate=sdf.parse(userBirth);
		
		System.out.println("바꾼 날짜  = " + endDate);
		ageVO.setPno(pno);
		ageVO.setBirth(endDate);
		ageVO.setGender(vo.getGender());
		ageVO.setUserId(vo.getUserId());
		
		int result =chartService.ageChartInsert(ageVO);
		rd.addFlashAttribute("msg", "결제가 완료되었습니다.");
		
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="/recommand" , method=RequestMethod.POST)
	public String recommandInsert(@RequestParam("pno") int pno,
								  @RequestParam("gender")String gender,
								  @RequestParam("height")int height,
								  @RequestParam("weight")int weight,
								  @RequestParam("reviews")String reviews,
								  @RequestParam("pSize")String pSize) {
		
		RecommandVO vo=new RecommandVO(pno, gender, height, weight, reviews, pSize, null,null);
		int result=boardService.recommandInsert(vo);
		System.out.println("recommandInsert =" + result);
		
		if(result==1) {
			return "success";
		}else if(result==0){
			return "fail";
		}else {
			return "fail";
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/getRecommandList", method=RequestMethod.GET)
	public ArrayList<RecommandVO> getRecommandList(@RequestParam("pno")int pno){
		ArrayList<RecommandVO> result=boardService.getRecommandList();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분");
		System.out.println(result.get(0).getPno());
		ArrayList<RecommandVO> list=new ArrayList();
		
		
		if(result.size()>0) {
			
		for(int i=0; i<result.size();i++) {
			String regdate=sdf.format(result.get(i).getRegdate());
			result.get(i).setRecommandDate(regdate);
			if(result.get(i).getPno()==pno) {
				list.add(result.get(i));
			}
		}
	}		
		
		return list;
	}
}
