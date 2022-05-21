package com.itwill.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.itwill.command.AdminVO;


public class AdminAuthHandler implements HandlerInterceptor{

	
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			
			// 세션가져오기
			HttpSession session = request.getSession();
			
			// adminVO로 저장되어있는 세션 찾아오기
			AdminVO adminVO= (AdminVO)session.getAttribute("adminVO");
			
			// 세션이 널이면 로그인 화면으로 보내주기
			if(adminVO==null) {
				response.sendRedirect(request.getContextPath()+"/admin/adminLogin");
				return false;
				
			}else {
				
			// 아니면 넘어가기
				return true;
			}
			// TODO Auto-generated method stub
		}
		
}
