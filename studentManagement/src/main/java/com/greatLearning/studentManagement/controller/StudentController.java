package com.greatLearning.studentManagement.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import com.greatLearning.studentManagement.entity.Student;
import com.greatLearning.studentManagement.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/All")
	public String allStudent(Model model) {
		
		List<Student> students = studentService.getAllStudents();
		System.out.println(students);
		model.addAttribute("students", students);
		return "allStudents";
		
	}
	
	@RequestMapping("/Delete/{studentId}")
	public RedirectView deleteStudent(@PathVariable("studentId") int studentId, HttpServletRequest request) {
		
		studentService.deleteStudent(studentId);
		RedirectView view = new RedirectView();
		view.setUrl(request.getContextPath() + "/All");
		return view;
		
	}
	
	@RequestMapping("/Add")
	public String addStudent(Model m) {
		
		m.addAttribute("title","Add Student");
		return "addStudentForm";
		
	}
	
	@RequestMapping(value = "/handle-student", method = RequestMethod.POST)
	public RedirectView handleStudent(@ModelAttribute Student student, HttpServletRequest request) {
		
		studentService.saveStudent(student);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+ "/All");
		return redirectView;
		
	}
	
	@RequestMapping("/Update/{studentId}")
	public String updateStudent(@PathVariable("studentId") int studentId, Model m) {
		
		Student s = studentService.getStudent(studentId);
		m.addAttribute("student", s);
		return "updateStudentForm";
		
	}
	
	@RequestMapping(value = "/update-student", method = RequestMethod.POST)
	public RedirectView updateHandler(@ModelAttribute Student student, HttpServletRequest request) {
		
		studentService.updateStudent(student);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+ "/All");
		return redirectView;
		
	}
	
}
