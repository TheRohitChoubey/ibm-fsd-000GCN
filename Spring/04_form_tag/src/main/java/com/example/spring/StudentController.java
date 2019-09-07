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
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDao dao = context.getBean("eDao", StudentDao.class);
		dao.createStudent(theStudent);
		return "student-process";
	}
	
	@GetMapping("/getData")
	public String getDetails(Model theModel) {
		 List<Map<String, Object>> studentsList;
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDao dao = context.getBean("eDao", StudentDao.class);
		studentsList = dao.getStudents();
		theModel.addAttribute("studentList",studentsList);
		return "student-detail";
	}
	
	@PostMapping("/getName")
	public String getByName(@ModelAttribute("student") Student theStudent,Model theModel) {
		 List<Map<String, Object>> studentsList;
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDao dao = context.getBean("eDao", StudentDao.class);
		studentsList = dao.getStudents();
		theModel.addAttribute("studentList",studentsList);
		return "student-detail";
	}
}
