package com.base.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

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
	
  // registeration of staff
	@PostMapping("/staffLogin")
	public String staff (@ModelAttribute StaffEntity staff, Model model) 
	{		 
		staffService.addstaff(staff);
		model.addAttribute(staff);
		return"staff/stafflogin";
		
	}
	//after adding staff
	@PostMapping("/adminAddsStaff")
	public String adminToAddStaff (@ModelAttribute StaffEntity staff, Model model) 
	{		 
		staffService.addstaff(staff);
		model.addAttribute(staff);
		return "Admin/admin";
		
	}
	//staff logs in
	@GetMapping("/staffLogin")
	private String stafflogin() 
	{
		return"staff/stafflogin";
	}
	
	// self registration of staff
	@GetMapping("/staffform")
	private String staffform() {
		return"staff/staffform";
	}

	
	@GetMapping("/staff")
	private String staff()
	{
		
		return"staff/staff";
	}
	//admin add student
	@GetMapping("/adminToAddStudent")
	private String adminToAddStudent()
	{
		
		return "Admin/adminToAddStudent";
	}
	@GetMapping("/adminToAddStaff")
	private String adminToAddStaff()
	{
		
		return "Admin/adminToAddStaff";
	}
	@GetMapping("/staffDashboard")
	public String staffDashboard(@ModelAttribute StaffEntity staffEntity, HttpSession session, Model model)
	{
		session.setAttribute("id", staffEntity.getStaffId());
		model.addAttribute("staff",staffEntity);
		return "staff/staffDashboard";
	}
	@PostMapping("/staffLoginCheck")
	public String login(@ModelAttribute StaffEntity staffEntity, HttpSession session,Model model)
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
		return "redirect:/staffsdetail";
	
	}
//	@GetMapping("/updateStaff{id}")
//	private String update(@PathVariable int id, @ModelAttribute StaffEntity staff, Model model,HttpSession session) 
//	{
//		model.addAttribute(model);
//		session.setAttribute("staffId", id);
//		StaffEntity staffupdate  = staffService.findByStaffId(id);
//		
//		if(staffupdate!=null)
//		{
//			model.addAttribute("staff",staffupdate);
//		}
//		else
//		{
//			model.addAttribute("staff",new StaffEntity());
//		}
//		return"staff/updateStaff";
//	}
	@GetMapping("/updateStaff1{id}")
	public String editDetails(@PathVariable int id, Model model)
	{
	    model.addAttribute("staff", staffService.findByStaffId(id));
		return "staff/updateStaff";
		
	}

	@PostMapping("/updateStaff{id}")
	public String updateDetails(@PathVariable int id,@ModelAttribute("staff") StaffEntity staff,Model model)
	{
	
		StaffEntity entityObj = staffService.findByStaffId(id); 
		if(entityObj!=null)
		{
			entityObj.setStaffId(id);
			entityObj.setStaffName(staff.getStaffName());
			entityObj.setStaffAge(staff.getStaffAge());
			entityObj.setStaffGender(staff.getStaffGender());
			entityObj.setStaffDOB(staff.getStaffDOB());
			entityObj.setStaffQualification(staff.getStaffQualification());
			entityObj.setStaffContact(staff.getStaffContact());
			entityObj.setStaffAddress(staff.getStaffAddress());
			entityObj.setStaffMail(staff.getStaffMail());
			entityObj.setStaffPassword(staff.getStaffPassword());

			
			staffService.addstaff(entityObj);
			
			return "redirect:/staffsdetail";
		
		}
		else
		{
			return "staff/staff";
		}
		
		
	}
	
	
}