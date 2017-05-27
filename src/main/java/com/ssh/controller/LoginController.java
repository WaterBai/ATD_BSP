package com.ssh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssh.entity.PersonTest;
import com.ssh.service.TestService;

@Controller
public class LoginController {

    @Autowired
    private TestService baseService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(@RequestParam Map<String, String> params) {
        System.out.println("home");
        return "home";
    }
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(@RequestParam Map<String, String> params) {
        System.out.println("index");
        String username = params.get("username");
        System.out.println(username);
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam Map<String, String> params) {
        System.out.println("login");
        String username = params.get("username");
        String password = params.get("password");
        System.out.println(username);
        System.out.println(password);
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        //view.addObject("username",username);
        return view;
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
        return b + "</br>" + person.toString();
    }
    
    /**
     * 用Map接收前端提交的Form Data或Query String，如果有相同的参数名，只接收第一个
     * @author XuJijun
     * @param params
     * @return
     */
    @RequestMapping(value = "map", method = RequestMethod.POST)
    public Map<String, Object> map(@RequestParam Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = params;
        System.out.println("map");
        System.out.println(params.get("username"));
        System.out.println(resultMap.get("password"));
        return resultMap;
    }
    
    /**
     * 用MultiValueMap接收前端提交的Form Data或Query String，可以接收相同的参数名的值到同一个list中
     * @author XuJijun
     * @param params
     * @return
     */
    @RequestMapping(value = "multiValueMap", method = RequestMethod.POST)
    public Map<String, List<Object>> multiValueMap(@RequestParam MultiValueMap<String, Object> params) {
        Map<String, List<Object>> resultMap = new HashMap<>();
        resultMap = params;
        System.out.println("map");
        /*System.out.println(params.get("username"));
        System.out.println(resultMap.get("password"));*/
        return resultMap;
    }
    
    /**
     * 用Map接收前端提交的json格式的Request Payload，如果有相同的参数名，只接收最后一个
     * @author XuJijun
     * @param params
     * @return
     */
    @RequestMapping(value = "jsonParams", method = RequestMethod.POST)
    public Map<String, Object> jsonParams(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = params;
        System.out.println("map");
        System.out.println(params.get("username"));
        System.out.println(resultMap.get("password"));
        return resultMap;
    }
}
