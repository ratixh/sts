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


public interface StudentService 
{
	public void addStudentDetails(StudentEntity place);
	public StudentEntity findByStudentEmailAndStudentPassword(String studentEmail,String studentPassword );
}
