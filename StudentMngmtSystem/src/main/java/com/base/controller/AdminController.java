package com.base.controller;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.base.entity.*;
import com.base.service.AdminService;

@Controller
public class AdminController {
	 @Autowired
	  private AdminService adminService;
	 
	@PostMapping("/adminLoginCheck")
	public String login(@ModelAttribute AdminEntity adminEntity)
	 {	
		
		  AdminEntity admin= adminService.findByAdminLoginAndAdminPassword(adminEntity.getAdminLogin(),
					  adminEntity.getAdminPassword());

			  if(Objects.isNull(admin))
			  {
	//			      return "redirect:/dashboard";
				  return "HomePage/dashboard";
			  }
			  else
			  {
	//			    return   "redirect:/admin"; 
				  return "Admin/admin";
			  }
	  }
}

