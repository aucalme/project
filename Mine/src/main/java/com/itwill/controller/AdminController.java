package com.itwill.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.admin.service.AdminService;
import com.itwill.command.AdminVO;
import com.itwill.command.EmailVO;
import com.itwill.command.ProductVO;
import com.itwill.email.service.EmailService;
import com.itwill.utill.AdminCriteria;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	@Qualifier("adminService")
	AdminService adminService;

	@Inject
	EmailService emailService;

	@RequestMapping("/adminLogin")
	public String adminLogin() {

		return "admin/adminlogin";
	}
	
	//관리자 로그아웃
		@RequestMapping("/adminLogout")
		public String adminLogout(HttpSession session,RedirectAttributes rd) {
			session.invalidate(); 
			
			rd.addFlashAttribute("msg", "관리자 로그아웃 되었습니다.");
			return "redirect:/admin/adminLogin";
		}

	@RequestMapping(value = "/updateAuth", method = RequestMethod.POST)
	public String updateAuth(String ranNum, EmailVO vo, Model model) {
		adminService.authNum(ranNum);

		// subject 메일 제목 body 메일 본문, host 보낼 사람
		String subject = "인증번호";
		String body = "입력 번호는 " + adminService.selectAuth();
		String host = adminService.selectEmail();
		
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

	
	@RequestMapping(value="/adminSubmit", method=RequestMethod.POST)
	public String adminSubmit(AdminVO vo, HttpSession session, Model model) {

		AdminVO adminVO = adminService.checkAdmin(vo);
		System.out.println(adminVO);
		if (adminVO != null) {

			session.setAttribute("adminVO", adminVO);
			return "redirect:/admin/adminpage";
		} else {
			model.addAttribute("msg", "아이디 비밀번호 또는 인증번호를 확인하세요.");
			return "admin/adminlogin";
		}

	}

	@RequestMapping("/adminpage")
	public String adminPage() {

		return "admin/adminpage";
	}

	@RequestMapping("/adminChat")
	public String adminChat() {
		return "admin/adminchat";
	}
	
	// 상품 수정 요청
	
	@ResponseBody
	@RequestMapping(value="/updateProduct", method=RequestMethod.POST)
	public String updateProduct(@RequestParam("pno") int pno,
								@RequestParam("pCategory") String pCategory,
								@RequestParam("pName") String pName,
								@RequestParam("price") String price,
								@RequestParam("pBrand") String pBrand,
								@RequestParam("uniqueName") String uniqueName,
								@RequestParam("pTitle") String pTitle,
								@RequestParam("pDetail") String pDetail,
								@RequestParam("file") MultipartFile file,
								HttpSession session
									) {
		
		System.out.println("pno =" + pno);
		System.out.println("pName ="+ pName);
		System.out.println("price =" + price);
		System.out.println("pBrand =" + pBrand);
		System.out.println("uniqueName= " + uniqueName);
		System.out.println("pTitle =" +pTitle);
		System.out.println("pDetail =" +pDetail);
		System.out.println("pCategory =" + pCategory);
		
		String p_imgAddr= null;
		
		try {
			Date date = new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			
			String uploadDate= sdf.format(date);
			File folder= new File(GLOBAL_LOCAL.UPLOAD_PATH);
			
			if(!folder.exists()) {
				folder.mkdir();	//폴더 생성
			}
			
			String fileRealName=file.getOriginalFilename();
			System.out.println(fileRealName);
			
			if(!fileRealName.equals("empty")) {
				
				//사이즈
				Long size=file.getSize();
				
				//저장된 전체 경로
				String uploadPath= folder.getPath();
				
				//확장자
				String fileExtention=fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length()); // 확장자 추출
				UUID uuid=UUID.randomUUID();
				String uuids=uuid.toString().replaceAll("-", ""); //가짜 파일명
				
				p_imgAddr=uploadDate+uuids+fileExtention;
				
				File saveFile=new File(uploadPath+"\\"+p_imgAddr);
				file.transferTo(saveFile);
				
			}
			
			//DB 작업
			
			ProductVO vo=new ProductVO(pno, pCategory, pName, pTitle, pBrand, uniqueName, price, pDetail, p_imgAddr, null, 0,0);
			
			int result=adminService.update(vo);
			if(result==1) {
				return "success";
			}else {
				
				return "fail";
			}
			
			
			
		} catch (Exception e) {
			return "idFail";
		}
		
	}
	
	
	// 상품목록 조회요청

	@ResponseBody
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET)
	public ArrayList<ProductVO> getProductList() {
		return adminService.getProductList();
	}

	// 상품 등록 요청
	@ResponseBody
	@RequestMapping(value = "registProduct", method = RequestMethod.POST)
	public String registProduct(@RequestParam("pName") String pName, @RequestParam("pCategory") String pCategory,
			@RequestParam("pTitle") String pTitle, @RequestParam("pBrand") String pBrand,
			@RequestParam("uniqueName") String uniqueName, @RequestParam("price") String price,
			@RequestParam("pDetail") String pDetail, @RequestParam("file") MultipartFile file) {

		try {

			// 업로드별 날짜 폴더 생성
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");

			String uploadDate = sdf.format(date);

			File folder = new File(GLOBAL_LOCAL.UPLOAD_PATH);

			if (!folder.exists()) {// 폴더가 없으면
				folder.mkdir(); // 폴더 생성
			}

			// 파일명
			String fileRealName = file.getOriginalFilename();
			System.out.println("fileRealName : " + fileRealName);

			// 사이즈
			Long size = file.getSize();
			System.out.println("size : " + size);

			// 저장된 전체 경로
			String uploadPath = folder.getPath();

			System.out.println("uploadPath : " + uploadPath);

			// 확장자
			String fileExtention = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length()); // 확장자
																													// 추출
			System.out.println("fileExtention : " + fileExtention);
			UUID uuid = UUID.randomUUID();

			System.out.println("uuid : " + uuid);
			String uuids = uuid.toString().replaceAll("-", ""); // 가짜 파일명
			System.out.println("uuids : " + uuids);
			String p_imgAddr = uploadDate + uuids + fileExtention;
			System.out.println("p_imgAddr : " + p_imgAddr);

			File saveFile = new File(uploadPath + "\\" + p_imgAddr);
			// TODO transferTo 파일 업로드 처리
			file.transferTo(saveFile);
			System.out.println("saveFile : " + saveFile);

			ProductVO vo = new ProductVO(0, pCategory, pName, pTitle, pBrand, uniqueName, price, pDetail, p_imgAddr,
					null, 0,0);
			int result = adminService.insert(vo);

			System.out.println("result : " + result);
			if (result == 1) {
				return "success";
			} else {
				return "fail";
			}

		} catch (NullPointerException e) {
			return "idFail";
		} catch (Exception e) {

			return "fail";
		}
	}

//	제품지우기
	@ResponseBody
	@PostMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("pno") ArrayList<String> pno) {

		// 잘 모르겠음 배낀거
		String match = "[^0-9A-Z\\\\s]";

		// pno 는 현재 [[?]] 상태로 있음
		for (int i = 0; i < pno.size(); i++) {
			pno.set(i, pno.get(i).replaceAll(match, ""));
			// [[]] 벗겨주는 과정
		}

		// ArrayList<FileUploadVO> 형태로 imgAddr을 list로 가져온다.
		ArrayList<ProductVO> fileList = adminService.getImgAddr(pno);
		int result = adminService.delete(pno);

		if (result == pno.size()) {
			for (int i = 0; i < pno.size(); i++) {
				// 파일 경로와 DB에 있는 p_imgAddr을 가져와서 파일에 저장
				File file = new File(GLOBAL_LOCAL.UPLOAD_PATH + "\\" + fileList.get(i).getP_imgAddr());
				if (file.exists()) {
					// 파일이 있으면 delete
					file.delete();
				}
			}

			// ajax로 data를 보냄
			return "success";
		} else {
			return "fail";
		}

	}

	// 필터 조회 요처청

	@ResponseBody
	@RequestMapping(value = "/getFilteredList", produces = "application/json", method = RequestMethod.POST)
	public ArrayList<ProductVO> getFilterdList(@RequestBody AdminCriteria cri) {

		System.out.println(cri.getCategory());

		return adminService.getFilteredList(cri);

	}

}
