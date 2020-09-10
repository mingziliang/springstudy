package com.baizhi.test;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestUserDAO {
    @Test
    public void testFindByName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        User user=userDAO.findByUserName("zhangsan");
        System.out.println("user = " + user);
    }

}
