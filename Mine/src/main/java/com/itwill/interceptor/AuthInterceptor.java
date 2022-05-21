package com.itwill.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

import com.itwill.command.UserVO;

// 로그인 상태인 지 아닌 지를 (세션에 로그인 아이디가 저장되어 있는 지)체크해서,
// 로그인 상태이면 원래 가고자 했던 페이지로 진행.
// 로그인 안 한 상태이면 로그인 페이지로 redirect.

public class AuthInterceptor implements HandlerInterceptor{ 
	
	// 요청 URL과 요청 방식에 매핑된 컨트롤러 메서드가 호출되기 전에
	// 요청(request)와 응답(response)를 가로채서 실행되는 메서드.
	// 요청 처리 전에 해야 할 일을 작성함.
	// 리턴 값의 의미: (1) true -> 다음 handler chain이 실행됨. (2) false: 요청 처리를 진행하지 않음.
	
	private static final Logger log = LoggerFactory.getLogger(AuthInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle() 호출");
		
		//로그인 상태 여부 체크 (1) 로그인 OK -> 진행. (2) 로그인 x -> userLogin 페이지
		HttpSession session = request.getSession();
		UserVO loginUserId = (UserVO)session.getAttribute("loginUserId");
		if(loginUserId != null) { // 로그인 정보가 있으면
			log.info("로그인 아이디: {}", loginUserId);
			return true;
		} else { // 로그인 정보가 없으면
			log.info("로그인 안됨.");
			// 요청 URL 정보를 찾아서, logIn 요청에 요청 파라미터를 추가
			String reqUrl = request.getRequestURL().toString();
			log.info("request URL: {}", reqUrl);
			//질의 문자열이 있는 지 확인
			String query = request.getQueryString();
			log.debug("Query String: {}", query);
			
			String target ="";
			// 특수기호들을 UTF-8 코드값으로 변환
			if(query == null) { // 질의 문자열이 없는 경우
				target = UriUtils.encode(reqUrl, "UTF-8");
			} else { // 질의 문자열이 있는 경우
				target = UriUtils.encode(reqUrl + "?" + query, "UTF-8");
			}
			reqUrl = UriUtils.encode(reqUrl, "UTF-8");
			log.debug("URI 디코딩 후: {}", reqUrl);
		
			response.sendRedirect("/mine/user/userLogin?url=" + target);
			return false; // 기존 요청을 진행하지 않음.
		}
		
	}
	
	// 컨트롤러 메서드가 리턴한 후 view(JSP 파일)에 모델 객체가 전달되기 전에 호출되는 메서드.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle() 호출");
	}
	
	// View(JSP 파일)가 호출되서 화면 (UI)가 완성된 이후 호출되는 메서드.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion() 호출");
	}
}
