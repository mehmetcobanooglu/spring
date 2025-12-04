package com.mehmetcobanoglu.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledExample {

    @Scheduled(cron = "* 28 13 * * *")
    public void calistir() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

}
