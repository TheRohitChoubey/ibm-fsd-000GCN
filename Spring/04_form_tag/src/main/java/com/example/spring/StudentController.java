package com.example.spring;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		theModel.addAttribute("student", student);
		return "student-process";
	}

	@PostMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent, Model theModel) {
		theModel.addAttribute("tempStudent", theStudent);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDao dao = context.getBean("eDao", StudentDao.class);
		dao.createStudent(theStudent);
		return "student-process";
	}

	@PostMapping("/searchByName")
	public String searchByName(@ModelAttribute("student") Student theStudent, Model theModel) {
		List<Map<String, Object>> studentsList;
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDao dao = context.getBean("eDao", StudentDao.class);
		studentsList = dao.searchStudent(theStudent);
		theModel.addAttribute("foundStudent", studentsList);
		return "student-process";
	}

	@GetMapping("/getData")
	public String getDetails(Model theModel) {
		List<Map<String, Object>> studentsList;
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDao dao = context.getBean("eDao", StudentDao.class);
		studentsList = dao.getStudents();
		theModel.addAttribute("studentList", studentsList);
		return "student-detail";
	}

	@GetMapping("/getName")
	public String getByName(@RequestParam String order) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDao dao = context.getBean("eDao", StudentDao.class);
		dao.deleteStudent(order);
		return "student-detail";
	}
}
