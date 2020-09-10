package com.baizhi.action;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Msg;
import com.baizhi.service.MsgService;
import com.baizhi.service.MsgServiceImpl;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MsgAction {
    private Msg msg;
    //接收参数
    public Msg getMsg() {
        return msg;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }



    private MsgService msgService = new MsgServiceImpl();

    /**
     * 查看所有评论信息
     */
    public String findAll() throws IOException{

        List<Msg> msgs = msgService.findAll();
        //将评论转为json
        String s = JSONObject.toJSONStringWithDateFormat(msgs,"yyyy-MM-dd HH:mm:ss");
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);
        return Action.NONE;
    }

    /**
     * 用来处理添加评论的方法
     * @return
     * @throws IOException
     */
    public String save() throws IOException {
        Map<String, Object> result = new HashMap<>();
        try {
            msgService.save(msg);
            result.put("status", true);
            result.put("msg", "评论成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.put("status",false);
            result.put("msg","评论失败！");
        }
        //3.处理响应，将result转为json响应前台
        String s = JSONObject.toJSONString(result);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);
        return Action.NONE;
    }

}
