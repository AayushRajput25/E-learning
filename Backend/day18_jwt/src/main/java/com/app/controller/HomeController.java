package com.app.controller;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ContentService;
import com.app.service.CourseService;
import com.app.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
@Validated
public class HomeController {

	@Autowired
	private CourseService course;
	
	@Autowired
	private UserService user;
	
	@GetMapping("/courses")
	public ResponseEntity<?> getAllCourses()
	{
//		int err = 404;
		return ResponseEntity.ok(course.getAllCourses());
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<?> getDetailsByEmail(@PathVariable String email)/*(Authentication auth)*/
	{
		System.out.println("In get email");
//		 String email = (String)auth.getPrincipal();
		return ResponseEntity.ok(user.getDetialByEmail(email));
	}
	
}
