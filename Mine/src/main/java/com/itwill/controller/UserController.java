package com.itwill.controller;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.admin.service.AdminService;
import com.itwill.board.service.BoardService;
import com.itwill.command.CartVO;
import com.itwill.command.EmailVO;
import com.itwill.command.ProductVO;
import com.itwill.command.UserVO;
import com.itwill.email.service.EmailService;
import com.itwill.user.service.UserService;


@Controller
@RequestMapping({"/user","/board"})
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	@Qualifier("boardService")
	BoardService boardService;
	
	@Autowired
	@Qualifier("adminService")
	AdminService adminService;

	@Inject
	EmailService emailService;
	
	@RequestMapping("/userLogin")
	public void userLogin(String url, Model model) {
		log.info("userLogin() GET 호출");
		System.out.println(">>>>> userLogin(url=" + url + ") GET invoked");
		
		// 로그인 페이지가 요청 됐을 때, 로그인 성공 후 이동할 페이지가 질의 문자열에 포함되어 있는 경우
		if(url != null && !url.equals("")) {
			model.addAttribute("url", url); // 로그인 이후 이동할 페이지를 저장.
		}
	}
	
	@PostMapping("/userLogin")
	public void userLogin(UserVO vo, Model model) {
		log.info("userLogin({}) POST 호출", vo);
		System.out.println(">>>>> userLogin(userVO=" + vo + ") POST invoked");
		
		UserVO logInUser = userService.login(vo);
		
		
		log.info("logInUser: {}", logInUser); // 로그인 O: not null, 로그인 X: null
		
		// 로그인 여부를 판단할 수 있는 정보를 Model 객체에 속성으로 저장.
		model.addAttribute("logInUser", logInUser);
		
	}

	@RequestMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}
	
	@PostMapping("/join")
	public String userJoin(UserVO vo, Model model,RedirectAttributes rd) {
		int result = userService.insert(vo);
		System.out.println(result);
		if(result==1) {
			rd.addFlashAttribute("msg", "회원가입 성공");
		}else {
			rd.addFlashAttribute("msg", "회원가입 실패");
		}
		
		return "redirect:/user/userLogin";
	}
	
	@RequestMapping(value = "userIdCheck", method = RequestMethod.POST)
	@ResponseBody
	public String usercheckId(String userId) {
		if(userService.isValidId(userId)) {
			return "valid";
		} else {
			return "invalid";
		}
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpSession session, RedirectAttributes rd) {
		session.removeAttribute("loginUserId");
		session.invalidate();
		rd.addFlashAttribute("msg", "로그아웃 되었습니다.");
		return "redirect:/";
	}
	
	@RequestMapping("/myPageCheck")
	public String myPageCheck() {
		return "user/myPageCheck";
	}
	
	@RequestMapping(value ="/myPageCheck" ,method=RequestMethod.POST)
	public String checkPw(HttpServletRequest request, @RequestParam("password")String pw, Model model) {
		HttpSession session = request.getSession();
		System.out.println(session);
		UserVO userVO= (UserVO)session.getAttribute("loginUserId");
		System.out.println(userVO);
		UserVO result = userService.check(userVO);
		System.out.println(result);
		
		System.out.println("POST myPageCheck session "+ userVO);
		
		
		if(result.getUserPw().equals(pw)) {
			model.addAttribute("UserVO", userVO);
			return "user/myPage";
		}else {
			return "redirect:/user/myPageCheck";
		}
	}
	
	@RequestMapping("/myPage")
	public String myPage() {
		
		
		return "user/myPage";
	}
	
	@PostMapping("/userUpdate")
	public String myPage(UserVO vo, Model model,HttpServletRequest request) {
		HttpSession session= request.getSession();
		UserVO userVO=(UserVO) session.getAttribute("loginUserId");
		System.out.println(userVO);
		System.out.println("UserZipCode :" + vo.getUserZipCode());
		
		int result = userService.update(vo);
		System.out.println(result);
		System.out.println("Post MyPage result = "+ result);
	
		model.addAttribute("UserVO", userVO);
		if(result==1){
			model.addAttribute("updateMsg","회원정보 수정이 완료되었습니다.");
		}else {
			model.addAttribute("updateMsg","회원정보 수정이 실패했습니다.");
		}
			
			return "user/myPage";
	
	}
	
	@RequestMapping("/cart")
	public String cart(HttpServletRequest request, Model model) {
		log.info("cart() 호출");
		
		HttpSession session=request.getSession();
		UserVO userVO=(UserVO) session.getAttribute("loginUserId");
		
		System.out.println("GET cart session userVO " + userVO);
		String userId=userVO.getUserId();
		ArrayList<CartVO> list=userService.cartSelect(userId);
		
		System.out.println(list);
		model.addAttribute("cartList", list);
		
		return "user/cart";
	}
	
	@PostMapping("/cart")
	public String cart(CartVO co) {
		
		System.out.println("POST cart Mapping");
		return "redirect:/user/cart";
	}
	@RequestMapping("/cartInsert")
	public String cartInsert(@RequestParam("pno")int pno, HttpServletRequest request,RedirectAttributes rd) {
		HttpSession session=request.getSession();
		
		// USER ID
		if(session.getAttribute("loginUserId")!=null) {
			
		UserVO userVO=(UserVO) session.getAttribute("loginUserId");
		
		String userId=userVO.getUserId();
		
		
		ProductVO productVO=boardService.cartProduct(pno);
		
		System.out.println("cartInsert "+ userId + productVO);
		
		CartVO vo=new CartVO();
		vo.setP_imgAddr(productVO.getP_imgAddr());
		vo.setPno(pno);
		vo.setPrice(Integer.parseInt(productVO.getPrice()));
		vo.setUserId(userId);
		vo.setpName(productVO.getpName());
		vo.setQuantity(1);
		
		System.out.println("CartVO =" +vo);
		userService.cartInsert(vo);
		
		rd.addFlashAttribute("msg", "장바구니에 담았습니다.");
		
		}
		return "redirect:/user/cart";
	}
	

	@RequestMapping("/findIdView")
	public String findIdView() {
		return"user/findIdView";
	}
	@RequestMapping("/findPw")
	public String findPw() {
		return "user/findPw";
	}
	@ResponseBody
	@RequestMapping(value="/findPwCheck", method=RequestMethod.GET)
	public String findPwCheck(@RequestParam("userId")String userId,@RequestParam("userEmail")String userEmail, HttpSession session) {
		UserVO vo=new UserVO();
		vo.setUserId(userId);
		vo.setUserEmail(userEmail);
		
		UserVO userVO=userService.findPwCheck(vo);
		if(userVO!=null) {
			session.setAttribute("UserVO", userVO);
			return "success";
		}else {
			
			return "fail";
		}
		
	}
	
	@RequestMapping(value="/updateAuth", method=RequestMethod.POST)
	public String updateAuth(String ranNum, EmailVO vo, Model model, @RequestParam("userEmail")String userEmail, @RequestParam("userId") String userId) {
		// subject 메일 제목 body 메일 본문, host 보낼 사람
				int result=userService.authNum(userId, ranNum);
				String subject = "인증번호";
				String body = "입력 번호는 " + userService.ranNum(userId);
				String host = userEmail;
				
				vo.setSenderName("MINE");
				vo.setSenderMail("wlsgh6650@gmail.com");
				vo.setReceiveMail(host);
				vo.setMessage(body);
				vo.setSubject(subject);
				
				try {

					emailService.sendMail(vo);
					model.addAttribute("message", "이메일이 발송되었습니다.");
					return "이메일이 발송되었습니다";
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("message", "이메일 발송 실패");
					return "이메일 발송 실패";
				}
	}
	
	@ResponseBody
	@RequestMapping(value="/authCheck" , method=RequestMethod.POST)
	public String authCheck(@RequestParam("authNum")String authNum, @RequestParam("userId")String userId) {
		
		String result=userService.authCheck(userId, authNum);
		
		if(!result.equals("")) {
			
			return result;
		}else {
			return "fail";
		}
	}
	
	@ResponseBody
	@PostMapping("/registPw")
	public String registPw(@RequestParam("userId")String userId, @RequestParam("ranNum")String ranNum) {
		int result=userService.registPw(userId, ranNum);
		
		String pw="";
		
		UserVO UserVO=new UserVO();
		UserVO.setUserId(userId);
		
		UserVO vo=(UserVO) userService.check(UserVO);
		
		if(result==1) {
			return vo.getUserPw();
		}else{
			return "fail";
		}
		
		
	}
	
	@PostMapping(value="/findId")
	public String findId(@RequestParam("userEmail")String userEmail, Model model) {
		System.out.println(userService.findId(userEmail));
		
		ArrayList<UserVO> list = (ArrayList<UserVO>) userService.findId(userEmail);
		
		
		System.out.println(list.size()+ "listsize");
		if(list.size()>0) {
			
			model.addAttribute("list", list);
		}else {
			model.addAttribute("noMsg", "가입된 아이디가 없습니다.");
		}
		
		return "user/findId";
		
	}
	
	@RequestMapping("/cartDelete")
	public String cartDelete(@RequestParam("pno")int pno, RedirectAttributes rd) {
		int result=userService.delete(pno);
		
		rd.addFlashAttribute("msg", "장바구니에서 삭제했습니다.");
		return "redirect:/user/cart";
	}

}
