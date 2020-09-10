package com.baizhi.dao;

import com.baizhi.entity.Msg;

import java.util.List;

public interface MsgDAO {
    //保存评论
    void save(Msg msg);

    List<Msg> findAll();
}
