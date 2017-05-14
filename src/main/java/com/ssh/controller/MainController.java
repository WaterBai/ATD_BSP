package com.ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.entity.Person;
import com.ssh.service.BaseService;
import com.ssh.service.PersonService;
import com.ssh.service.TestService;

@Controller
public class MainController {

    @Autowired
    private TestService testService;

    @Autowired
    private BaseService baseService;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        System.out.println("ok");
        // 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        return "NewFile";
    }

    @RequestMapping(value = "springtest", method = RequestMethod.GET)
    public String springTest() {
        return testService.test();
    }

    @RequestMapping(value = "savePerson", method = RequestMethod.GET)
    @ResponseBody
    public String savePerson() {
        personService.savePerson();
        return "success!";
    }

    @RequestMapping(value = "testBaseAdd", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseAdd() {
        baseService.savePerson();
        return "success!";
    }

    @RequestMapping(value = "testBaseGetById", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseGetById() {
        Person per = baseService.getById(Person.class, 1L);
        System.out.println(per.toString());
        return "success!";
    }
}
