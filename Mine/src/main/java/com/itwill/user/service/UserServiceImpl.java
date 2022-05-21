package com.itwill.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.command.CartVO;
import com.itwill.command.UserVO;
import com.itwill.user.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int insert(UserVO vo) {
		return userMapper.insert(vo);
	}

	@Override
	public UserVO login(UserVO vo) {

		return userMapper.login(vo);
	}

	@Override
	public boolean isValidId(String userId) {

		UserVO vo = userMapper.check(userId);
		if (vo == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserVO check(UserVO vo) {
		return userMapper.check(vo);
	}

	@Override
	public int cartInsert(CartVO co) {
		return userMapper.cartInsert(co);
	}

	public ArrayList<CartVO> cartSelect(String userId) {
		return userMapper.cartSelect(userId);
	}

	@Override
	public List<UserVO> findId(String userEmail) {
		return userMapper.findId(userEmail);
	}

	@Override
	public int findIdCheck(String userEmail) {
		return userMapper.findIdCheck(userEmail);
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return userMapper.update(vo);
	}

	@Override
	public int delete(int pno) {
		// TODO Auto-generated method stub
		return userMapper.delete(pno);
	}
	
	@Override
	public UserVO findPwCheck(UserVO vo) {
		// TODO Auto-generated method stub
		return userMapper.findPwCheck(vo);
	}
	
	@Override
	public int authNum(String userId, String ranNum) {
		// TODO Auto-generated method stub
		return userMapper.authNum(userId, ranNum);
	}
	
	@Override
	public int ranNum(String userId) {
		// TODO Auto-generated method stub
		return userMapper.ranNum(userId);
	}
	
	@Override
	public String authCheck(String userId, String authNum) {
		// TODO Auto-generated method stub
		return userMapper.authCheck(userId, authNum);
	}

	
	@Override
	public int registPw(String userId, String ranNum) {
		// TODO Auto-generated method stub
		return userMapper.registPw(userId, ranNum);
	}
}
