package com.baizhi.service;

import com.baizhi.entity.Msg;

import java.util.List;

public interface MsgService
{
    //保存评论信息
    void save(Msg msg);

    List<Msg>  findAll();

}
