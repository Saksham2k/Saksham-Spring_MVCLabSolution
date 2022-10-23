package com.greatLearning.studentManagement.services;

import java.util.List;

import com.greatLearning.studentManagement.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	
	public void saveStudent(Student student);
	
	public void deleteStudent(int id);
	
	public Student getStudent(int id);
	
	public void updateStudent(Student student); 

}
