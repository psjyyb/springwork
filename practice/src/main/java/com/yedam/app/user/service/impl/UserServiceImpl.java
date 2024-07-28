package com.yedam.app.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.user.mapper.UserMapper;
import com.yedam.app.user.service.UserService;
import com.yedam.app.user.service.UserVO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVO findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void createUser(UserVO user) {
        userMapper.insertUser(user);
    }
}
