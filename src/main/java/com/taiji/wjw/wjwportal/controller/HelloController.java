package com.taiji.wjw.wjwportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    @RequestMapping("hello")
    @ResponseBody
    public void helo() {
        System.out.println("helleo");
    }
}
