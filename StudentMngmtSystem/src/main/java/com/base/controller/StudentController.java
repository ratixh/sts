package com.base.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String studentDatabase(Model model) {
		List<StudentEntity>  list =  studentService.displayAllStudentList();
		model.addAttribute("student", list);
				
		return "Student/studentDatabase";
	}
	@GetMapping("/adminToStudentDatabase")
	public String adminToStudentDatabase(Model model) {
		List<StudentEntity>  list =  studentService.displayAllStudentList();
		model.addAttribute("student", list);
				
		return "Admin/adminToStudentDatabase";
	}
	

	@PostMapping("/saveStudentDetails")
	public String studentDetails(@ModelAttribute StudentEntity studentEntityObj)
	{
		studentService.addStudentDetails(studentEntityObj);
		return "Student/StudentLogin";
	}
	@PostMapping("/saveStudentDetails1")
	public String studentDetails1(@ModelAttribute StudentEntity studentEntityObj)
	{
		studentService.addStudentDetails(studentEntityObj);
		return "Admin/admin";
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
	@GetMapping("/updateStudent1{id}")
	public String editDetails(@PathVariable int id, Model model)
	{
	    model.addAttribute("student", studentService.findByStudentId(id));
		return "Student/updateStudent";
		
	}

	@PostMapping("/updateStudent{id}")
	private String update(@PathVariable int id, @ModelAttribute("student") StudentEntity student, Model model) 
	{
		StudentEntity studentupdate  = studentService.findByStudentId(id);
		studentupdate.setStudentId(id);
		StudentEntity entityObj = studentService.findByStudentId(id); 
		if(entityObj!=null)
		{
			entityObj.setStudentId(id);
			entityObj.setStudentName(student.getStudentName());
			entityObj.setStudentBranch(student.getStudentBranch());
			entityObj.setStudentPhoneno(student.getStudentPhoneno());
			entityObj.setStudentCountry(student.getStudentCountry());
			entityObj.setStudentDateOfBirth(student.getStudentDateOfBirth());
			entityObj.setStudentAcademicYear(student.getStudentAcademicYear());
			entityObj.setStudentCity(student.getStudentCity());
			entityObj.setStudentAddress(student.getStudentAddress());
			entityObj.setStudentEmail(student.getStudentEmail());
			entityObj.setStudentPassword(student.getStudentPassword());
			entityObj.setStudentDegree(student.getStudentDegree());
			entityObj.setStudentState(student.getStudentState());
			

			
			studentService.addStudentDetails(entityObj);
			
			return "redirect:/adminToStudentDatabase";
		
		}
		else
		{
			return "Admin/admin";
		}
		
	}
	@GetMapping("/deleteStudent{id}")
	private String delete(@PathVariable int id) 
	{
		
		StudentEntity studentEntity  = studentService.findByStudentId(id);
		if(studentEntity!=null)
		{
			   studentService.deleteByStudentId(id);
		}
		return "redirect:/adminToStudentDatabase";
	
	}
}