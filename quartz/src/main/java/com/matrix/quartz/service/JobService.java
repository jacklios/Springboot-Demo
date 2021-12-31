package com.matrix.quartz.service;

import java.util.concurrent.ExecutionException;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JobService {
    
    @Autowired
    private Scheduler scheduler;
    
    public void addJob(String jobName, String parameter) {
        try {
            // 启动scheduler
            if(!scheduler.isStarted())
                scheduler.start();

            // 创建JobDetail实例
            JobDetail jobDetail = JobBuilder.newJob(SampleJob.class)
            .withIdentity(jobName,"sampleJ")
            //JobDataMap可以给任务传递参数
            .usingJobData("parameter", parameter)
            .build();

            // Cron表达式： "0/5 * * * * ? 2018"
            // CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();
            
            // 每5秒钟调用一次
            SimpleScheduleBuilder simpleScheduler = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();

            // 创建Trigger触发器设置使用cronSchedule方式调度
            Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity(jobName)
            .startNow()
            .withSchedule(simpleScheduler)
            .build();

            // 注册JobDetail实例到scheduler并设置对应的Trigger触发时机
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info(e.toString());
        }
    }

    public void delJob(String jobName) {
        try {
            scheduler.deleteJob(JobKey.jobKey(jobName));
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info(e.toString());
        }
    }

    public void pauseJob(String jobName) {
        try {
            TriggerKey trigger = TriggerKey.triggerKey(jobName);
            scheduler.pauseTrigger(trigger);
            scheduler.unscheduleJob(trigger);
            scheduler.pauseJob(JobKey.jobKey(jobName));
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info(e.toString());
        }
    }

    public void resumeJob(String jobName){
        try {
            scheduler.resumeJob(JobKey.jobKey(jobName));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
 
}
