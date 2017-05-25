package com.ssh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssh.entity.PersonTest;
import com.ssh.service.TestService;

@Controller
public class LoginController {


    @Autowired
    private TestService baseService;


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login() {
        System.out.println("ok");
        // 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        return "index";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register() {
        PersonTest person = new PersonTest();
        System.out.println(person.toString());
        person.setUsername("XRog");
        person.setPhone("18381005946");
        person.setAddress("chenDu");
        person.setRemark("this is XRog");
        System.out.println(person.toString());
        boolean b = baseService.addEntity(person);
        System.out.println(person.toString());
        return b + "</br>"+person.toString();
    }
}
