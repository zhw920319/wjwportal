package com.taiji.wjw.wjwportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.taiji.wjw.wjwportal.mapper")
public class WjwPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjwPortalApplication.class, args);
        System.out.println("启动成功！");
    }

}
