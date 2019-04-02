package com.wuque.springbootschedule.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @ClassName AsyncConfig
 * @Description TODO
 * @Author huawei
 * @Date 2019/4/2 22:31
 * @Version 1.0
 **/

@Configuration
@EnableAsync
@Slf4j
public class AsyncConfig {

    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);    //核心线程池个数
        executor.setMaxPoolSize(100);   //最大线程池个数
        executor.setQueueCapacity(10);  //队列长度
        executor.setKeepAliveSeconds(10);   //闲置10秒后释放
        executor.initialize();
        return executor;
    }
}
