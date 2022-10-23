package com.greatLearning.studentManagement.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.greatLearning.studentManagement.entity.Student;

@Component
public class StudentServiceImpl implements StudentService {


	@Autowired
	private HibernateTemplate template;
	

	@Override
	public List<Student> getAllStudents() {
		
		List<Student> allStudents = template.loadAll(Student.class);
		
		return allStudents;
	}


	@Override
	@Transactional
	public void saveStudent(Student student) {
		
		this.template.save(student);
		
	}
	
	@Transactional
	public void deleteStudent(int id) {
		
		Student s = this.template.load(Student.class, id);
		this.template.delete(s);
	} 
	
	public Student getStudent(int id) {
		
		Student s = this.template.get(Student.class, id);
		return s;
	}
	
	@Transactional
	public void updateStudent(Student student) {
		
		this.template.saveOrUpdate(student);

	}
	
	
	

}
