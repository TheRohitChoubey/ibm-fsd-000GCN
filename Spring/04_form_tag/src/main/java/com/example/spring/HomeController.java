package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@GetMapping
	public String getHome() {
		return "main-menu";
	}
	
	@PostMapping("/processForm")
	public String processPage() {
		return "student-process";
	}
}
