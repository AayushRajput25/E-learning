package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ContentService;
import com.app.service.CourseService;
import com.app.service.StudentService;
import com.app.service.TeacherService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private TeacherService teacher;
	
	@Autowired
	private StudentService student;
	
	@Autowired
	private ContentService content;
	
	@Autowired
	private CourseService course;
	
	@GetMapping("/admin/teacher")
	public ResponseEntity<?> getAllTeacher(){
		System.out.println("inside get ALL TEACHERS");
		return ResponseEntity.ok(teacher.getAllTeachers()) ;
	}
	
	@GetMapping("/admin/student")
	public ResponseEntity<?> getAllStudent(){
		System.out.println("inside get ALL Student");
		return ResponseEntity.ok(student.getAllStudent()) ;
	}
	
	
}
