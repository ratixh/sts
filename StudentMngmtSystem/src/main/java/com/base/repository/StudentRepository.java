package com.base.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.base.entity.*;


public interface StudentRepository extends JpaRepository<StudentEntity, Integer>
{
	public StudentEntity findByStudentEmailAndStudentPassword(String studentEmail,String studentPassword );
}
