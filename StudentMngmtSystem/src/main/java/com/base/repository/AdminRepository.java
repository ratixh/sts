package com.base.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.base.entity.*;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer>{
	
	public AdminEntity findByAdminLoginAndAdminPassword(String adminLogin, String adminPassword);

}
