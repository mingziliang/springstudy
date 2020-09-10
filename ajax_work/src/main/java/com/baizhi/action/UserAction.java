package com.baizhi.action;


import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;
import com.baizhi.utils.VerifyCodeUtils;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class UserAction {

    private User user;
    private String code;
    private UserService userService = new UserServiceImpl();


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 处理用户登录方法
     */
    public String login() throws IOException {
        System.out.println("用户信息"+user);
        System.out.println("验证码"+code);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        Map<String,Object> result = new HashMap<>();
        try {
            //比较用户输入的验证码和session中验证码
            String sessioncode = (String) ServletActionContext.getRequest().getSession().getAttribute("code");
            if (sessioncode.equalsIgnoreCase(code)){
                //登录
                User userDB = userService.login(this.user);
                //放入session作用域
                ServletActionContext.getRequest().getSession().setAttribute("user",userDB);
                //响应信息
                result.put("status",true);
                result.put("msg","登录成功!");
            }else {
                throw  new RuntimeException("验证码输入错误！");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            result.put("status",false);
            result.put("msg",e.getMessage());
        }
        //将map转为json
        String json = JSONObject.toJSONString(result);
        writer.println(json);
        return Action.NONE;
    }



    /*
    生产验证码的方法
     */
    public String getImage() throws IOException {
        //1.生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //2.验证码存入session
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("code", code);
        //3.生成图片
        HttpServletResponse response = ServletActionContext.getResponse();
        ServletOutputStream os = response.getOutputStream();
        VerifyCodeUtils.outputImage(220,80,os,code);
        return Action.NONE;
    }

}
