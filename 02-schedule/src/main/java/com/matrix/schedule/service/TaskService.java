package com.matrix.schedule.service;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TaskService {
     /**
     * Cron表达式：每5秒执行一次
     * CRON表达式    含义 
        "0 0 12 * * ?"    每天中午十二点触发 
        "0 15 10 ? * *"    每天早上10：15触发 
        "0 15 10 * * ?"    每天早上10：15触发 
        "0 15 10 * * ? *"    每天早上10：15触发 
        "0 15 10 * * ? 2005"    2005年的每天早上10：15触发 
        "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发 
        "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发 
        "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发 
        "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发 
        "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发 
        "0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void CronTask() {
        log.info("[CronTask]：{}, Thread: {}", new Date().toString(), Thread.currentThread().getName());
    }

    /**
     * 固定执行频率：每10秒执行一次
     */
    @Scheduled(fixedRate = 10000)
    public void FinedRateTask() {
        log.info("[FinedRateTask]：{}, Thread: {}", new Date().toString(), Thread.currentThread().getName());
    }

    /**
     * 延迟5秒，每隔6秒执行一次
     */
    @Scheduled(fixedDelay = 6000, initialDelay = 5000)
    public void DelayTask() {
        log.info("[DelayTask]：{}, Thread: {}", new Date().toString(), Thread.currentThread().getName());
    }
}
