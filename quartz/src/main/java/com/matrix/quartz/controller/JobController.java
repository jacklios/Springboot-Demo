package com.matrix.quartz.controller;

import javax.annotation.Resource;
import com.matrix.quartz.service.JobService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/jobs")
public class JobController {
    @Resource
    private JobService jobService; 
    
    @PostMapping("/{jobName}")
    @ResponseBody
    public void add(@PathVariable("jobName") String jobName, @RequestParam("param") String parameter){
        jobService.addJob(jobName, parameter);
    }
    
    @DeleteMapping("/{jobName}")
    public void delete(@PathVariable("jobName") String jobName){
        jobService.delJob(jobName);
    }

    @PutMapping("/{jobName}/status/{status}")
    public void updateJobStatus(@RequestParam("jobName") String jobName,  @PathVariable("status") String status){
        switch(status){
            case("resume"):
                jobService.resumeJob(jobName);
                return;
            case("pause"):
                jobService.pauseJob(jobName);
                return;
            default:
                return;
        } 
    }
    
}
