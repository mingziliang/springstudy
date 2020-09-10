package com.baizhi.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    /**
     * 返回sqlsession的方法
     *
     */
    private  static  SqlSessionFactory sqlSessionFactory;
    private  static ThreadLocal<SqlSession> t = new ThreadLocal<>();
    static {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is );
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    /**
     * 返回sqlsession的方法
     *
     */
    public  static SqlSession getSqlSession(){
        SqlSession sqlSession = t.get();
        if(sqlSession==null){
            sqlSession=sqlSessionFactory.openSession();
            t.set(sqlSession);
        }
        return sqlSessionFactory.openSession();
    }
    /**
     * 关闭sqlSeesion
     */
    public static  void closeSqlSession() {
        SqlSession sqlSession = t.get();
        if(sqlSession!=null)sqlSession.close();
    }
}