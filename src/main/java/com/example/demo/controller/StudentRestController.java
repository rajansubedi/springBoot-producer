package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.service.StudentService;


@RestController
@RequestMapping("api/student/")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class StudentRestController {
	
	@Autowired
	StudentService studentService;
	
	
	@RequestMapping({ "validateLogin" })
	public User validateLogin() {
		return new User("User successfully authenticated");
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	  public List<Student>  addStudents(@RequestBody Student student){
		 studentService.addStudents(student);
		 List<Student> list = studentService.getAllStudents();
		 return list;
		 
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT)
	  public Student  updateStudent(@RequestBody Student student){
		System.out.println(student);
		
			return studentService.updateStudent(student);
			
		
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public List<Student>  deleteStudent(@PathVariable("id")int id){
		studentService.deleteStudent(id);
		return studentService.getAllStudents();
		
	}
	
	@RequestMapping(value = "getAllStudents", method = RequestMethod.GET)
	  public List<Student>  getAllStudents(){
			return studentService.getAllStudents();
		
	}
	
	@RequestMapping(value = "getStudent/{id}", method = RequestMethod.GET)
	  public Student  getStudent(@PathVariable("id") int id){
		return studentService.getStudent(id);
		
	}
		
}
