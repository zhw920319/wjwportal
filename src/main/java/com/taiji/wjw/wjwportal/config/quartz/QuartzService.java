package com.taiji.wjw.wjwportal.config.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.management.MalformedObjectNameException;
import java.util.Date;

@Component
@Slf4j
public class QuartzService {
    @Scheduled(cron = "0 0 0 * * ?") // 每天晚上12点执行一次
    public void work()  {
        log.info("非集群定时："+ new Date());
    }
}
