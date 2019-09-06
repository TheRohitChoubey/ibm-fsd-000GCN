package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/")
	public String viewPage() {
		return "index";
	}
	
	@GetMapping("/formView")
	public String processPage(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student",student);
		return "student-process";
	}
	
	@PostMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent,Model theModel) {
		theModel.addAttribute("tempStudent",theStudent);
		return "student-detail";
	}
}
