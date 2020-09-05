package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDAO {
    //查询所有方法
    List<User> findAll();
}
