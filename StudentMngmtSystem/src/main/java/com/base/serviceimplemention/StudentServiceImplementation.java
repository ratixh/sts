
package com.base.serviceimplemention;

import java.util.List;

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

	@Override
	public List<StudentEntity> displayAllStudentList() {
		
		return studentRepository.findAll();
	}

	@Override
	public StudentEntity findByStudentId(int id) {
		// TODO Auto-generated method stub
		return  studentRepository.findById(id).get();
	}

	@Override
	public void deleteByStudentId(int id) {
		 
				// TODO Auto-generated method stub
			     studentRepository.deleteById(id);
			}
	
	}
  

