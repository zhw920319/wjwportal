package com.taiji.wjw.wjwportal;

import com.taiji.wjw.wjwportal.entity.User;
import com.taiji.wjw.wjwportal.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WjwPortalApplicationTests {

    @Autowired
    private IUserService service;

    @Test
    void contextLoads() {
        User user = service.getById(1);
        List<User> users = service.queryListByPageNo(0, 10);
        users.forEach(userss -> {
            System.out.println(userss.toString());
        });
        System.out.println(user.toString());
    }

}
