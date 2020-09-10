package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    @Override
    public User login(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        try {
            //跟据用户的书如命查询数据库
            User userDB = userDAO.findByUserName(user.getUsername());
            //如果查询到用户，说明用户正确，对比密码
            if (userDB != null) {
                if (userDB.getPassword().equals(user.getPassword())) {
                    return userDB;
                } else {
                    throw new RuntimeException("密码不正确！");
                }
            } else {
                throw new RuntimeException("用户名不存在！");
            }
        }finally {
            MybatisUtils.closeSqlSession();
        }

    }
}
