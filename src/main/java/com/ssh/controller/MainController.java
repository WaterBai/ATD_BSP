package com.ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.PersonService;
import com.ssh.service.TestService;

@Controller
public class MainController {

	@Autowired
	private TestService testService;

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
	@RequestMapping(value = "getPersons", method = RequestMethod.GET)
	@ResponseBody
	public String getPersons() {
		personService.savePerson();
		return "success!";
	}
}
