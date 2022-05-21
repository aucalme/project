package com.itwill.user.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwill.command.CartVO;
import com.itwill.command.UserVO;

public interface UserMapper {

	int insert(UserVO vo);
	UserVO login(UserVO vo);
	UserVO check(String userId);
	UserVO check(UserVO vo);
	int cartInsert(CartVO co);
	ArrayList<CartVO> cartSelect(String userId);
	List<UserVO> findId(String userEmail);
	int findIdCheck(String userEmail);
	int update(UserVO vo);
	
	int delete(int pno);
	UserVO findPwCheck(UserVO vo);
	public int authNum(@Param("userId")String userId, @Param("ranNum")String ranNum);
	public int ranNum(String userId);
	public String authCheck(@Param("userId")String userId, @Param("authNum")String authNum);
	public int registPw(@Param("userId")String userId, @Param("ranNum")String ranNum);	
}
