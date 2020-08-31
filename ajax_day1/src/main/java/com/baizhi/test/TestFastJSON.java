package com.baizhi.test;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;

import java.util.Date;

public class TestFastJSON {
    public static void main(String[] args) {
        User user = new User("21","小陈",23,new Date());
        //java 对象转为json
        String jsonString = JSONObject.toJSONString(user);
        System.out.println("jsonString = " + jsonString);
    }
}
