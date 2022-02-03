package com.jasonsystem.demo.service;

import com.jasonsystem.demo.model.UserVO;
import com.jasonsystem.demo.repository.UserMapper;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserMapper userMapper;

    public UserVO getUserId(String userId) {
        return userMapper.selectUserId(userId);
    }
}
