package com.base.serviceimplemention;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.entity.*;
import com.base.repository.*;
import com.base.service.*;

@Service
public class AdminServiceImplementation implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public AdminEntity findByAdminLoginAndAdminPassword(String adminLogin, String adminPassword) {
		
		 AdminEntity adminEntity=  adminRepository.findByAdminLoginAndAdminPassword(adminLogin, 
				 adminPassword);
		return adminEntity;
	}
}