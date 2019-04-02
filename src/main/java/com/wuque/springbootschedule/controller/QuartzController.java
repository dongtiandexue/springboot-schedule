package com.wuque.springbootschedule.controller;

import com.wuque.springbootschedule.config.MyQuartzScheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName QuartzController
 * @Description Quartz定时任务接口
 * @Author huawei
 * @Date 2019/4/2 23:11
 * @Version 1.0
 **/

@RestController
@RequestMapping("/quartz")
public class QuartzController {

    @Autowired
    private MyQuartzScheduler myQuartzScheduler;

    @RequestMapping("/start")
    public void startQuartzJob() {
        try {
            myQuartzScheduler.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/info")
    public String getQuartzJob(@RequestParam("name") String name, @RequestParam("group") String group) {
        String info = null;
        try {
            info = myQuartzScheduler.getJobInfo(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return info;
    }

    @RequestMapping("/modify")
    public boolean modifyQuartzJob(@RequestParam("name") String name, @RequestParam("group") String group, @RequestParam("time") String time) {
        boolean flag = true;
        try {
            flag = myQuartzScheduler.modifyJob(name, group, time);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping(value = "/pause")
    public void pauseQuartzJob(@RequestParam("name") String name, @RequestParam("group") String group) {
        try {
            myQuartzScheduler.pauseJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/pauseAll")
    public void pauseAllQuartzJob() {
        try {
            myQuartzScheduler.pauseAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/delete")
    public void deleteJob(@RequestParam("name") String name, @RequestParam("group") String group) {
        try {
            myQuartzScheduler.deleteJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
