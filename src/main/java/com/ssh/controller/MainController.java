package com.ssh.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.entity.PageResults;
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
        Person person = new Person();
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
        Person per = baseService.getById(Person.class, 1L);
        System.out.println(per.toString());
        return per.toString();
    }

    @RequestMapping(value = "testBaseDelete", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseDelete() {
        Person person = new Person();
        person.setId(1L);
        boolean b = baseService.removeEntity(person);
        return b + "";
    }

    @RequestMapping(value = "testBaseUpdate", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseUpdate() {
        Person person = new Person();
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
        List<Person> result = baseService.queryBySql(null, null, Person.class);
        for (Person person : result) {
            System.out.println(person.toString());
        }
        return result.toString();
    }

    @RequestMapping(value = "testBasePage", method = RequestMethod.GET)
    @ResponseBody
    public String testBasePage() {
        PageResults<Person> result = baseService.queryPageBySql(null, null, 0, 0, Person.class);
        for (Person person : result.getResults()) {
            System.out.println(person.toString());
        }
        return result.toString();
    }
    
    @RequestMapping(value = "testBasePage2", method = RequestMethod.GET)
    @ResponseBody
    public String testBasePage2() {
        PageResults<Map<String, Object>> result = baseService.queryPageBySql(null, null, 0, 0);
        for (Map<String, Object> person : result.getResults()) {
            System.out.println(person.toString());
        }
        return result.toString();
    }
}
