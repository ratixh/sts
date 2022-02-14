package com.base.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.base.entity.*;

public interface AdminRepository extends JpaRepository<AdminEntity, Long>{
	
	public AdminEntity findByAdminLoginAndAdminPassword(String adminLogin, String adminPassword);

}
