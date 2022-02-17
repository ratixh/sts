package com.base.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.base.entity.StaffEntity;
import com.base.service.StaffService;

@Controller
public class StaffController {
	@Autowired
	private StaffService staffService;
	
 
	@PostMapping("/homes")
	public String staff (@ModelAttribute StaffEntity staff, Model model) 
	{		 
		staffService.addstaff(staff);
		model.addAttribute(staff);
		return"staff/stafflogin";
		
	}
	@GetMapping("/staffLogin")
	private String stafflogin() 
	{
		return"staff/stafflogin";
	}
		
	@GetMapping("/staffform")
	private String staffform() {
		return"staff/staffform";
	}

	
	@GetMapping("/staff")
	private String staff()
	{
		
		return"staff/staff";
	}
	
	@PostMapping("/staffLoginCheck")
	public String login(@ModelAttribute StaffEntity staffEntity)
	 {	
		  StaffEntity staff= staffService.findByStaffMailAndStaffPassword(staffEntity.getStaffMail(), 
				  staffEntity.getStaffPassword());
       System.out.println(staffEntity.getStaffMail()+""+staffEntity.getStaffPassword());
			  if(staff==null)
				  
			  {
				  
				      return "staff/stafflogin";
			  }
			  else
			  {
				    return   "staff/staff";   
			  }
	  }
	
	@GetMapping("/staffsdetail")
	private String stafflist(Model model) 
	{
		
		List<StaffEntity>  list =  staffService.displayAllStaffList();
		model.addAttribute("staffform", list);
		
		
		return"staff/staffsdetail";
	}
	
	@GetMapping("/deletestaff{id}")
	private String delete(@PathVariable int id) 
	{
		
		StaffEntity staffEntity  = staffService.findByStaffId(id);
		if(staffEntity!=null)
		{
			   staffService.deleteByStaffId(id);
		}
		return"staff/staffsdetail";
	
	}
	
}