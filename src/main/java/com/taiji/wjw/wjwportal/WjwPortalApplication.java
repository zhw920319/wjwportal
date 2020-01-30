package com.taiji.wjw.wjwportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.taiji.wjw.wjwportal.mapper")
@EnableScheduling //开启基于注解的定时任务
public class WjwPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjwPortalApplication.class, args);
        System.out.println("启动成功！");
    }

}
