package com.ssh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.entity.Attend;
import com.ssh.page.PageBean;
import com.ssh.repository.impl.BaseRepositoryImpl;
import com.ssh.service.AttendService;
import com.ssh.service.TestService;
import com.ssh.util.JsonUtil;

@Controller
@RequestMapping(value = "attend")
public class AttendController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AttendController.class);

    @Autowired
    private TestService baseService;
    @Autowired
    private AttendService attendService;

    /*
     * @RequestMapping(value = "index") public String index() {
     * LOGGER.debug("index"); // 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
     * return "attend/attend"; }
     */

    @RequestMapping(value = "attend")
    public String attend() {
        LOGGER.debug("attend");
        // 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        return "attend/attend";
    }

    @RequestMapping(value = "getAtdList")
    @ResponseBody
    public String getAtdList() {
        LOGGER.error("getAtdList");
        PageBean<Attend> atdPageBean = attendService.getAtdPage(
                "atd.getAttend", null);
        return JsonUtil.PageJson(atdPageBean);
    }

    @RequestMapping(value = "addAtdList")
    @ResponseBody
    public String addAtdList() {
        LOGGER.error("addAtdList");
        // PageBean<Attend>
        // atdPageBean=attendService.getAtdPage("atd.getAttend", null);
        //return JsonUtil.JsonSuccess(success, obj);
        return "";
    }

    @RequestMapping(value = "work")
    public String work() {
        LOGGER.debug("work");
        // 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        return "attend/work";
    }

}
