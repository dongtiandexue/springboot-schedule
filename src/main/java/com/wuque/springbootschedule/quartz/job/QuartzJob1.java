package com.wuque.springbootschedule.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName QuartzJob1
 * @Description TODO
 * @Author huawei
 * @Date 2019/4/2 22:53
 * @Version 1.0
 **/
@Slf4j
public class QuartzJob1 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("=====job1===开始执行 {}",System.currentTimeMillis());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("=====job1===结束执行 {}",System.currentTimeMillis());
    }
}
