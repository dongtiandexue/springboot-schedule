package com.wuque.springbootschedule.shedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyShedule
 * @Description 定时任务
 * @Author huawei
 * @Date 2019/4/2 22:10
 * @Version 1.0
 **/

@Component
@Slf4j
public class MyShedule {

    /**
     * cron表达式触发定时任务
     */
    @Async
    @Scheduled(cron = "0/5 * * * * *")
    public void test1(){
        log.info("===========> cron方式执行定时任务 {}",new Date());
    }

    /**
     * 上次任务执行结束后间隔时间执行，单位毫秒
     */
    @Async
    @Scheduled(fixedDelay = 2000)
    public void test2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        log.info("===========> fixedDelay方式执行定时任务 {}",new Date());
    }

    /**
     * 上次任务开始执行后间隔时间执行，单位毫秒
     */
    @Async
    @Scheduled(fixedRate = 200)
    public void test3() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        log.info("===========> fixedRate方式执行定时任务 {}",new Date());
    }
}
