package com.matrix.schedule.config;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

public class TaskConfig implements SchedulingConfigurer{
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(taskExecutor());
    }

    /**
     * 设置定时任务线程池，设置10个名称为 task-开头的线程
     * @return : Executor
     */
    @Bean
    public Executor taskExecutor() {
        return new ScheduledThreadPoolExecutor(10, new ThreadFactoryBuilder().setNamePrefix("task-").build());
    }
}
