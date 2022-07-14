package com.test.integration;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronTrigger {

    private final ConfigurableApplicationContext context;

    public CronTrigger(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void printMessage() {
        CustomGateway customGateway = context.getBean(CustomGateway.class);
        customGateway.start("https://worldtimeapi.org/api/timezone/Etc/UTC");
    }
}
