package com.ssh.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.entity.PersonTest;
import com.ssh.page.PageBean;
import com.ssh.service.BaseService;

@Controller
public class MainController {


    @Autowired
    private BaseService baseService;


    @RequestMapping(value = "springtest", method = RequestMethod.GET)
    public String springtest() {
        System.out.println("ok");
        // 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        return "NewFile";
    }

    @RequestMapping(value = "testBaseAdd", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseAdd() {
        PersonTest person = new PersonTest();
        person.setUsername("XRog");
        person.setPhone("18381005946");
        person.setAddress("chenDu");
        person.setRemark("this is XRog");
        boolean b = baseService.addEntity(person);
        return b + "";
    }

    @RequestMapping(value = "testBaseGetById", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseGetById() {
        PersonTest per = baseService.getById(PersonTest.class, 1L);
        System.out.println(per.toString());
        return per.toString();
    }

    @RequestMapping(value = "testBaseDelete", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseDelete() {
        PersonTest person = new PersonTest();
        person.setId(1L);
        boolean b = baseService.removeEntity(person);
        return b + "";
    }

    @RequestMapping(value = "testBaseUpdate", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseUpdate() {
        PersonTest person = new PersonTest();
        person.setId(5L);
        Date d = new Date();
        person.setRemark(d.toString());
        baseService.updateEntity(person);
        return baseService.updateEntity(person) + "";
    }

    @RequestMapping(value = "testBaseQuerySql", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseQuerySql() {
        List<Map<String, Object>> result = baseService.queryBySql(null, null);
        for (Map<String, Object> person : result) {
            System.out.println(person.toString());
        }
        return result.toString();
    }

    @RequestMapping(value = "testBaseQuerySql2", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseQuerySql2() {
        List<PersonTest> result = baseService.queryBySql(null, null, PersonTest.class);
        for (PersonTest person : result) {
            System.out.println(person.toString());
        }
        return result.toString();
    }

    @RequestMapping(value = "testBasePage", method = RequestMethod.GET)
    @ResponseBody
    public String testBasePage() {
        PageBean<PersonTest> result = baseService.queryPageBySql(null, null, 0, 0, PersonTest.class);
        for (PersonTest person : result.getResults()) {
            System.out.println(person.toString());
        }
        return result.toString();
    }
    
    @RequestMapping(value = "testBasePage2", method = RequestMethod.GET)
    @ResponseBody
    public String testBasePage2() {
        PageBean<Map<String, Object>> result = baseService.queryPageBySql(null, null, 0, 0);
        for (Map<String, Object> person : result.getResults()) {
            System.out.println(person.toString());
        }
        return result.toString();
    }
}
