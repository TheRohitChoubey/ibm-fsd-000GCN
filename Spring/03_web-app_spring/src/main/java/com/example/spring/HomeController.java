package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String goHome()
	{
		return "main-menu";
	}
	
	/*
	@RequestMapping("/user")
	public String goUser()
	{
		return "main-user";
	}
	*/
}
