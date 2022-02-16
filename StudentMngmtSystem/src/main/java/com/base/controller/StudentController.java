package com.base.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


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

	@GetMapping("/signup")
	public String base() {
		
		return "Student/StudentSignin";
	}
	@GetMapping("/StudentLogin")
	public String StudentLogin() {
		
		return "Student/StudentLogin";
	}
	@GetMapping("/display")
	public String display() {
		
		return "HomePage/display";
	}
	@GetMapping("/home")
	public String home() {
		
		return "HomePage/display";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		
		return "HomePage/dashboard";
	}
	@GetMapping("/adminLogin")
	public String admin() {
		
		return "Admin/adminLogin";
	}
	@GetMapping("/admin")
	public String adminLogin() {
		
		return "Admin/admin";
	}
	
	@GetMapping("/contactUs")
	public String contactUs() {
		
		return "HomePage/contactUs";
	}
	
	@GetMapping("/StudentDashboard")
	public String studentLogin() {
		
		return "Student/studentDashboard";
	}
	@GetMapping("/studentDatabase")
	public String studentDatabase() {
		
		return "Student/studentDatabase";
	}
	

	@PostMapping("/saveStudentDetails")
	public String studentDetails(@ModelAttribute StudentEntity studentEntityObj)
	{
		studentService.addStudentDetails(studentEntityObj);
		return "Student/StudentLogin";
	}
	@PostMapping("/verifylogin")
	public String verifyLogin(@ModelAttribute StudentEntity studentEntityObj)
	{
		
		StudentEntity entity = studentService.findByStudentEmailAndStudentPassword(studentEntityObj.getStudentEmail(), studentEntityObj.getStudentPassword());
		if(Objects.isNull(entity))
		{
			return "redirect:/StudentLogin";
		}
		else
		{
			return "redirect:/StudentDashboard";
		}
	}
}