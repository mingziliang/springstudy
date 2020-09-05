package com.baizhi.test;

import com.baizhi.service.UserServiceImpl;
import com.baizhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class TestMysqlUtils {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        System.out.println("sqlSession = " + sqlSession);
       // UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        //userDAO.findAll().forEach(user -> System.out.println("user = " + user));
        UserServiceImpl userService = new UserServiceImpl();
        userService.findAll().forEach(user -> System.out.println("user = " + user));
    }
}
