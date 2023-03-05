package com.stu.multithreading.server;

import com.stu.multithreading.entity.Msg;
import com.stu.multithreading.handler.CacService;
import com.stu.multithreading.handler.CacTask;
import com.stu.multithreading.handler.CalService2;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class TaskServer {
    private List<Msg> msgList;

    private final TaskExecutor taskExecutor;

    private final CacService cacService;

    public TaskServer(TaskExecutor taskExecutor, CacService cacService) {
        this.taskExecutor = taskExecutor;
        this.cacService = cacService;
    }

    public List<CompletableFuture> execute() {
        if (msgList.isEmpty()) {
            return null;
        }

        List<CompletableFuture> futureList = new ArrayList<>();

        for (Msg msg : msgList) {
            CompletableFuture future = CompletableFuture.runAsync(new CacTask(msg, cacService), taskExecutor);
            futureList.add(future);
        }

        CompletableFuture future = CompletableFuture.runAsync(new CacTask(new Msg(null,"kakaka", 1, new Date(), "kakka"), new CalService2()), taskExecutor);
        futureList.add(future);

        return futureList;

    }


    public void setMsgList(List<Msg> msgList) {
        this.msgList = msgList;
    }

    public List<Msg> getMsgList() {
        return msgList;
    }
}
