package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDAO {
    //根据用户名查用户信息
    User findByUserName(String username);
}
