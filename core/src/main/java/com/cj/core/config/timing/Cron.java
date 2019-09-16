package com.cj.core.config.timing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class Cron {


    @Autowired
    private DBService dbService;

    @Scheduled(cron = "0 0 4 * * *")
    @Async("getAsyncExecutor")
    public void scheduled(){
        log.info("=====>>>>>数据备份");
        dbService.backup();
    }

}
