package com.stu.multithreading.handler;

import com.stu.multithreading.entity.Msg;
import com.stu.multithreading.entity.Trace;
import com.stu.multithreading.mapper.MsgMapper;
import com.stu.multithreading.mapper.TraceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CacService implements MyTaskService {

    private MsgMapper msgMapper;

    private TraceMapper traceMapper;

    public CacService(MsgMapper msgMapper, TraceMapper traceMapper) {
        this.msgMapper = msgMapper;
        this.traceMapper = traceMapper;
    }

    @Transactional
    @Override
    public void sendMsg(Msg msg) throws InterruptedException {
        int cnt = msgMapper.insert(msg);
        Thread.sleep(100);
        traceMapper.insert(new Trace(null, msg.getId()));
    }
}
