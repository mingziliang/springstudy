package com.baizhi.test;

import com.baizhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMybatisUtils {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        System.out.println("sqlSession = " + sqlSession);
    }
}

