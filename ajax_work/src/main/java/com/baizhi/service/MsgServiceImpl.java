package com.baizhi.service;

import com.baizhi.dao.MsgDAO;
import com.baizhi.entity.Msg;
import com.baizhi.entity.User;
import com.baizhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MsgServiceImpl implements MsgService {



    @Override
    public void save(Msg msg) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MsgDAO msgDAO = sqlSession.getMapper(MsgDAO.class);
        try {//ctrl+ alt +T try-catch
            msg.setId(UUID.randomUUID().toString());
            msg.setCreateTime(new Date());
            msg.setUpcounts(0);
            //获取session中用户信息
            User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
           msg.setUserid(user.getId());
           // msg.setUserid("1");
            msgDAO.save(msg);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }

    @Override
    public List<Msg> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MsgDAO msgDAO = sqlSession.getMapper(MsgDAO.class);
        try {
            List<Msg>   msgs =msgDAO.findAll();
            return msgs;
        }  finally {
            MybatisUtils.closeSqlSession();
        }
    }
}
