package com.yedam.app.user.service;

public interface UserService {
    UserVO findByUsername(String username);
    void createUser(UserVO user);
}
