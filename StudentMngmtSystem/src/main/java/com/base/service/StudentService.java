//package com.base.service;
//
//import com.base.entity.StudentEntity;
//
//public interface StudentService {
//	
//	public void addStudent(StudentEntity student);
//}
package com.base.service;

import java.util.List;

import com.base.entity.*;

public interface StudentService {
	List<StudentEntity> getAllStudents();
	
	StudentEntity saveStudent(StudentEntity student);
	
	StudentEntity getStudentById(Long id);
	
	StudentEntity updateStudent(StudentEntity student);
	
	void deleteStudentById(Long id);
}