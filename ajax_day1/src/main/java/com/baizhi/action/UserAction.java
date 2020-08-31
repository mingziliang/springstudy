package com.baizhi.action;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAction      {
    private String username;
    private  String id;
    /*
        根据一个id查询一个ajax请求处理
     */
    public  String findOne() throws IOException{
        //1.收集数据
        //2.调用业务方法
        User user = new User(id,"小陈",23,new Date());
        //3.处理响应
        String jsonString = JSONObject.toJSONStringWithDateFormat(user,"yyyy-MM-dd");
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(jsonString);
        return null;
    }

    /*
    查询所有用户
     */
    public String findAll() throws IOException{
        User user1 = new User("1","小陈",23,new Date());
        User user2 = new User("2","小刘",24,new Date());
        User user3 = new User("3","小梁",25,new Date());
        List<User>  users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        //处理响应
        String s=JSONObject.toJSONStringWithDateFormat(users, "yyyy-MM-dd");
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);
        return Action.NONE;
    }


    /**
     * 用来处理ajax请求验证用户名
     * ajax 只认字符串
     * @return
     */
    public String checkName() throws IOException {
        System.out.println("username="+username);
        //1.收集数据
        //2.调用业务
        HttpServletResponse response = ServletActionContext.getResponse();
        //response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        if ("zhangsan".equals(username)) {
            response.getWriter().println("用户名可以使用!");
        }else {
            response.getWriter().println("用户名无效!");
        }
        //3.处理响应

        return null;

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
