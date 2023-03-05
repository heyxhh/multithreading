package com.stu.multithreading.handler;

import com.stu.multithreading.entity.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacTask implements Runnable{

    private final static Logger logger = LoggerFactory.getLogger(CacTask.class);

    private Msg msg;

    MyTaskService taskService;

    public CacTask(Msg msg, MyTaskService taskService) {
        this.msg = msg;
        this.taskService = taskService;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        logger.info(threadName + "---" + msg.toString());
        try {
            taskService.sendMsg(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
