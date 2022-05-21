package com.itwill.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.command.CartVO;
import com.itwill.command.UserVO;

public interface UserService {

	int insert(UserVO vo);
	UserVO login(UserVO vo);
	boolean isValidId(String userId);
	UserVO check(UserVO vo);
	int cartInsert(CartVO co);
	ArrayList<CartVO> cartSelect(String userId);
	List<UserVO> findId(String userEmail);
	int findIdCheck(String userEmail);
	int update(UserVO vo);
	int delete(int pno);
	
	UserVO findPwCheck(UserVO vo);
	public int authNum(String userId, String ranNum);
	public int ranNum(String userId);
	public String authCheck(String userId, String authNum);
	public int registPw(String userId, String ranNum);
}
