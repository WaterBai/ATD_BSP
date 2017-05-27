package com.ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssh.service.TestService;

@Controller
@RequestMapping(value = "attend")
public class AttendController {


    @Autowired
    private TestService baseService;

    @RequestMapping(value = "index")
    public String index() {
        System.out.println("index");
        // 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        return "attend/attend";
    }

    @RequestMapping(value = "attend")
    public String attend() {
        System.out.println("attend");
        // 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        return "attend/attend";
    }
    @RequestMapping(value = "work")
    public String work() {
        System.out.println("work");
        // 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        return "attend/work";
    }
}
