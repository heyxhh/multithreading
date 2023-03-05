package com.stu.multithreading.handler;

import com.stu.multithreading.entity.Msg;

public class CalService2 implements MyTaskService{

    @Override
    public void sendMsg(Msg msg) throws InterruptedException {
        String s = null;
        System.out.println(s.length());
    }
}
