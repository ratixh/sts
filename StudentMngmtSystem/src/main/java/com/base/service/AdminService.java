package com.base.service;
import com.base.entity.*;

public interface AdminService 
{
    public AdminEntity  findByAdminLoginAndAdminPassword(String adminLogin, String adminPassword);
	
}







