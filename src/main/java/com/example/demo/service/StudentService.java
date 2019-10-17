package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;



@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	public Student  addStudents(Student student){
		Student stu = repository.save(student);
		return stu;
		
	}
	
	  public Student  updateStudent(Student student){
		  Optional<Student> opt = repository.findById(student.getStudentId());
		  if(opt.isPresent()) {
			  Student stu = opt.get();
			  stu.setFirstName(student.getFirstName());
			  stu.setLastName(student.getLastName());
			  stu.setGender(student.getGender());
			  stu.setMaritalStatus(student.getMaritalStatus());
			  stu.setEmail(student.getEmail());
			  stu.setPhone(student.getPhone());
			   Student std = repository.save(stu);
			   return std;
		  }
		  
		  else {
			  return student;
		  }
		  
	}
	
	  public List<Student>  deleteStudent(int id){
		  Optional<Student> optional = repository.findById(id);
		  if(optional.isPresent()) {
			  Student stu = optional.get();
			  repository.delete(stu);
			  List<Student> list = repository.findAll();
			  return list;
		  }
		  
		  else {
			  List<Student> list = repository.findAll();
			  return list;
		  }
		
	}
	
	  public List<Student>  getAllStudents(){
		  List<Student> list = repository.findAll();
		  return list;
		
	}
	
	  public Student  getStudent(int id){
		Optional<Student> optional = repository.findById(id);
		if(optional.isPresent()) {
			Student stu = optional.get();
			return stu;
		}
		else {
			return null;
		}
		
	}
	
	
}
