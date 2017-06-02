package com.ssh.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssh.entity.PersonTest;
import com.ssh.entity.User;
import com.ssh.service.TestService;
import com.ssh.service.UserService;

@Controller
@RequestMapping(value = "login")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(@RequestParam Map<String, String> params) {
        LOGGER.info("home");
        return "home";
    }
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(@RequestParam Map<String, String> params) {
        LOGGER.info("index");
        String username = params.get("username");
        LOGGER.info(username);
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam Map<String, String> params) {
        LOGGER.info("login");
        ModelAndView view = new ModelAndView();
        String username = params.get("username");
        String password = params.get("password");
        LOGGER.info(username);
        LOGGER.info(password);
        view.setViewName("redirect:/login/index.do");
        return view;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView register(User user) {
        LOGGER.info("register");
        LOGGER.info(user.toString());
        ModelAndView view = new ModelAndView();
        view.addObject(user);
        view.setViewName("redirect:/login/login.do");
        return view;
    }
    
    /**
     * 用Map接收前端提交的Form Data或Query String，如果有相同的参数名，只接收第一个
     * @author XuJijun
     * @param params
     * @return
     */
    /*@RequestMapping(value = "map", method = RequestMethod.POST)
    public Map<String, Object> map(@RequestParam Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = params;
        LOGGER.debug((String) params.get("username"));
        LOGGER.debug((String) resultMap.get("password"));
        return resultMap;
    }*/
    
    /**
     * 用MultiValueMap接收前端提交的Form Data或Query String，可以接收相同的参数名的值到同一个list中
     * @author XuJijun
     * @param params
     * @return
     */
    /*@RequestMapping(value = "multiValueMap", method = RequestMethod.POST)
    public Map<String, List<Object>> multiValueMap(@RequestParam MultiValueMap<String, Object> params) {
        Map<String, List<Object>> resultMap = new HashMap<>();
        resultMap = params;
        LOGGER.debug("map");
        LOGGER.debug(params.get("username"));
        LOGGER.debug(resultMap.get("password"));
        return resultMap;
    }*/
    
    /**
     * 用Map接收前端提交的json格式的Request Payload，如果有相同的参数名，只接收最后一个
     * @author XuJijun
     * @param params
     * @return
     */
    /*@RequestMapping(value = "jsonParams", method = RequestMethod.POST)
    public Map<String, Object> jsonParams(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = params;
        LOGGER.debug((String) params.get("username"));
        LOGGER.debug((String) resultMap.get("password"));
        return resultMap;
    }*/
}
