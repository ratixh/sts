
package com.base.serviceimplemention;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.entity.*;
import com.base.repository.StudentRepository;
import com.base.service.StudentService;


@Service
public class StudentServiceImplementation implements StudentService{

	@Autowired
	StudentRepository studentRepository ;
	
	@Override
	public void addStudentDetails(StudentEntity studentEntityObj) {
		
		studentRepository.save(studentEntityObj);
		
	}
	
	public StudentEntity findByStudentEmailAndStudentPassword(String studentEmail,String studentPassword )
	{
		return studentRepository.findByStudentEmailAndStudentPassword(studentEmail, studentPassword);
	}

}
