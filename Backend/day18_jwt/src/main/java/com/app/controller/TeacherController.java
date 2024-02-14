package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CoursesDto;
import com.app.entities.Courses;
import com.app.service.TeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class TeacherController {

	@Autowired
	private TeacherService teacher;
	
	
	
	
	
	@PostMapping("/{teacherId}")
	public ResponseEntity<?> addCourse(@PathVariable Long teacherId,@RequestBody CoursesDto course){
		
		System.out.println("in add course"+course);
		return ResponseEntity.status(HttpStatus.CREATED).body(teacher.newCourseByTID(teacherId,course));
	}
	
	
	//for testing
	@GetMapping
	public ResponseEntity<?> getCourses()
	{
		System.out.println("in get courser");
		return ResponseEntity.ok(teacher.getAllCourses());
	}
	
	
	
}
