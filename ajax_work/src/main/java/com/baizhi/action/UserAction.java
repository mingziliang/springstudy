package com.baizhi;


import com.baizhi.utils.VerifyCodeUtils;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserAction {
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
