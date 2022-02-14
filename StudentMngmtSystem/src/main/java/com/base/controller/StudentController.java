package com.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.entity.*;
import com.base.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle list students and return mode and view
	
	// handler method to handle delete student request
	

//		return "redirect:/students";

	@GetMapping("/base")
	public String base() {
		
		return "base";
	}
	@GetMapping("/display")
	public String display() {
		
		return "display";
	}
	@GetMapping("/home")
	public String home() {
		
		return "home";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		
		return "dashboard";
	}
	@GetMapping("/adminLogin")
	public String adminLogin() {
		
		return "adminLogin";
	}
	@GetMapping("/contactUs")
	public String contactUs() {
		
		return "contactUs";
	}
	
//	@GetMapping("/studentLogin")
//	public String studentLogin() {
//		
//		return "studentLogin";
//	}
	@GetMapping("/registration")
	private String registation(@ModelAttribute StudentEntity students, Model model) {

		studentService.saveStudent(students);
	//	model.addAttribute("StudentEntity", students);
		return "registration";

	}
}