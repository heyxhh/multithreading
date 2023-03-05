package com.stu.multithreading.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolConfig {

    private static  final Logger logger = LoggerFactory.getLogger(ThreadPoolConfig.class);

    @Value("${thread.pool.corePoolSize}")
    private int corePoolSize;
    @Value("${thread.pool.maxPoolSize}")
    private int maxPoolSize;
    @Value("${thread.pool.queueCapacity}")
    private int queueCapacity;
    @Value("${thread.pool.keepAliveSeconds}")
    private int keepAliveSeconds;
    @Value("${thread.pool.namePrefix}")
    private String namePrefix;


    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 设置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 设置队列容量
        executor.setQueueCapacity(queueCapacity);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 设置默认线程名称
        executor.setThreadNamePrefix(namePrefix);
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        logger.info("创建一个线程池 corePoolSize is [" + corePoolSize + "] maxPoolSize is [" + maxPoolSize + "] queueCapacity is [" + queueCapacity +
                "] keepAliveSeconds is [" + keepAliveSeconds + "] namePrefix is [" + namePrefix + "].");
        return executor;
    }
}
