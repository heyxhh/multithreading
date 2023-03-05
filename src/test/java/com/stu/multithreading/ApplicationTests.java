package com.stu.multithreading;


import com.stu.multithreading.entity.Msg;
import com.stu.multithreading.handler.CalService2;
import com.stu.multithreading.server.TaskServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private TaskServer taskServer;

	@Test
	void contextLoads() {
	}

	@Test
	void testServer() {
		List<Msg> msgList = new ArrayList<>();

		long start = System.currentTimeMillis();

		for (int i = 0; i < 50; i++) {
			msgList.add(new Msg(null,"aiai"+i, 1, new Date(), "aiai"+i));
		}


		taskServer.setMsgList(msgList);


		List<CompletableFuture> completableFutures = taskServer.execute();

		CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()])).join();

		System.out.println("所以任务执行完毕, 花费的时间：" + (System.currentTimeMillis() - start));
	}

}
