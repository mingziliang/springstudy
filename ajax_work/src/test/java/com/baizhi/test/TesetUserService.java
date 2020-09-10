package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserServiceImpl;
import org.junit.Test;

public class TesetUserService {
    @Test
    public void testLogin(){
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        User login = userService.login(user);
        System.out.println("login = " + login);
    }

}
