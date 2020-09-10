package com.baizhi.entity;

import java.util.Date;

public class Msg {
    private String id;
    private  String msg;
    private Date createTime;
    private Integer upcount;
    private String userid; //评论用户id

    public Msg() {
    }

    public Msg(String id, String msg, Date createTime, Integer upcounts, String userid) {
        this.id = id;
        this.msg = msg;
        this.createTime = createTime;
        this.upcount = upcount;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "id='" + id + '\'' +
                ", msg='" + msg + '\'' +
                ", createTime=" + createTime +
                ", upcounts=" + upcount +
                ", userid='" + userid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpcounts() {
        return upcount;
    }

    public void setUpcounts(Integer upcounts) {
        this.upcount = upcounts;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
