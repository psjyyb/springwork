package com.yedam.app.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.app.security.mapper.UserMapper;
import com.yedam.app.security.service.LoginUserVO;
import com.yedam.app.security.service.UserVO;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	private UserMapper userMapper;

	public CustomerUserDetailsService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override // 인증을 하기위한 정보 조회 넘겨 받은 아이디가 실제 회원으로 있는지아닌지만 체크한다.
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userMapper.getUserInfo(username);

		if (userVO == null) {
			throw new UsernameNotFoundException(username);
		}

		return new LoginUserVO(userVO);
	}

}
