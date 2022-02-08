//package com.base.serviceimplemention;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.base.entity.StudentEntity;
//import com.base.repository.StudentRepository;
//import com.base.service.StudentService;
//
//@Service
//public class StudentServiceImplementation implements StudentService
//{
//	@Autowired
//	StudentRepository repo; 
//	@Override
//	public void addStudent(StudentEntity student) {
//		// TODO Auto-generated method stub
//		repo.save(student);
//	}
//
//	
//}
package com.base.serviceimplemention;

import java.util.List;

import org.springframework.stereotype.Service;

import com.base.entity.*;
import com.base.repository.StudentRepository;
import com.base.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService{

	private StudentRepository studentRepository;
	
	public StudentServiceImplementation(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public StudentEntity saveStudent(StudentEntity student) {
		return studentRepository.save(student);
	}

	@Override
	public StudentEntity getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public StudentEntity updateStudent(StudentEntity student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}

}
