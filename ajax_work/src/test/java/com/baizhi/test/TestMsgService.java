package com.baizhi.test;

import com.baizhi.entity.Msg;
import com.baizhi.service.MsgServiceImpl;
import org.junit.Test;

public class TestMsgService {
    private  MsgServiceImpl msgService = new MsgServiceImpl();

    @Test
    public void TestMsg(){

        Msg msg = new Msg();
        msg.setMsg("美女真好看！！！111");
        msgService.save(msg);
    }
    @Test
    public void  findAll(){
        msgService.findAll().forEach(msg -> System.out.println("msg = " + msg));
    }

}
