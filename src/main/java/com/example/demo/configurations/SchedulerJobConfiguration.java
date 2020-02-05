package com.example.demo.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Configuration
@EnableScheduling
public class SchedulerJobConfiguration {

    @Scheduled(fixedDelay = 10000L, initialDelay = 1000L)
    public void scheduledJob() {
        System.out.println("Job has been executed");
    }
}
