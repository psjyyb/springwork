package com.yedam.app.user.mapper;

import com.yedam.app.user.service.UserVO;

public interface UserMapper {

	// 유저 정보 조회
	UserVO findByUsername(String username);

	// 유저 등록
	void insertUser(UserVO user);
}
