package com.ssh.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.entity.Attend;
import com.ssh.page.PageBean;
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
     * LOGGER.info("index"); // 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
     * return "attend/attend"; }
     */

    @RequestMapping(value = "attend")
    public String attend() {
        LOGGER.info("attend");
        return "attend/attend";
    }

    @RequestMapping(value = "getAtdList")
    @ResponseBody
    public String getAtdList(@RequestParam Map<String, String> params) {
        LOGGER.info("getAtdList-params:" + params.toString());
        PageBean<Attend> atdPage = attendService.getAttendPage(params);
        return JsonUtil.PageJson(atdPage);
    }

    @RequestMapping(value = "addAtdList")
    @ResponseBody
    public String addAtdList(@RequestParam Map<String, String> params) {
        LOGGER.info("addAtdList-params:" + params.toString());
        boolean atdPage = attendService.addAttend(params);
        return JsonUtil.JsonSuccess(atdPage, atdPage);
    }

    @RequestMapping(value = "work")
    public String work() {
        LOGGER.info("work");
        return "attend/work";
    }

}
