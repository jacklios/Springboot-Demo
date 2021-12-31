package com.matrix.quartz.service;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Component
public class SampleJob implements Job{
    private String parameter;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException{
        log.info("Welcome to Spring Boot: " + parameter);
    }
    
}
