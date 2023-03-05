package com.stu.multithreading.handler;

import com.stu.multithreading.entity.Msg;

public interface MyTaskService {
    public void sendMsg(Msg msg) throws InterruptedException;
}
