package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl  implements UserService{
    @Override
    public List<User> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        try {
        List<User> users = userDAO.findAll();
        return users;
        }finally {
            sqlSession.close();
        }
    }
}
