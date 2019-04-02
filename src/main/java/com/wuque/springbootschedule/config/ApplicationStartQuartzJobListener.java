package com.wuque.springbootschedule.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @ClassName ApplicationStartQuartzJobListener
 * @Description 配置监听器，项目启动时启动定时任务
 * @Author huawei
 * @Date 2019/4/2 22:59
 * @Version 1.0
 **/

@Configuration
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MyQuartzScheduler myQuartzScheduler;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            //启动定时任务
            myQuartzScheduler.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public Scheduler scheduler() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }
}
