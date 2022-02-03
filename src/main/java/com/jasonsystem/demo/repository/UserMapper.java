package com.jasonsystem.demo.repository;

import com.jasonsystem.demo.model.UserVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserVO selectUserId(String userId);
}
