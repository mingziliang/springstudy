package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //查询所有用户信息
    List<User> findAll();
}
