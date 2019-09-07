package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, name = "/showView")
	public String showHelloWorldForm() {
		return "helloworld-form";
	}

	@RequestMapping(method = RequestMethod.POST, name = "/processForm")
	public String processStudentForm() {
		return "hello-world";
	}
}
