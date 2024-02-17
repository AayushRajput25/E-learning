package com.app.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Enrollment;
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
	
	
	@GetMapping("/teacher")
	public ResponseEntity<?> getAllTeacher(){
		System.out.println("inside get ALL TEACHERS");
		return ResponseEntity.ok(teacher.getAllTeachers()) ;
	}
	
	@GetMapping("/student")
	public ResponseEntity<?> getAllStudent(){
		System.out.println("inside get ALL Student");
		return ResponseEntity.ok(student.getAllStudent()) ;
	}
	
	@GetMapping("/course/{teacherId}")
	public ResponseEntity<?> getCourses(@PathVariable @NotNull Long teacherId)
	{
		System.out.println("in get courser" + teacherId);
		return ResponseEntity.ok(teacher.getCoursesById(teacherId));
	}
	
	@GetMapping("/course_content/{CourseId}")  // getting all contents assosiated with a course 
	public ResponseEntity<?> getContentBYContentId(@PathVariable @NotNull Long CourseId)
	{
		System.out.println("in get content by course id" + CourseId);
		return ResponseEntity.ok(content.getCoursesById(CourseId));
	}

	@DeleteMapping("/teacher/{teacherID}")
	public ResponseEntity<?> deleteTeacher(@PathVariable Long teacherID){
		System.out.println("to delete Teacher "+teacherID);
		return ResponseEntity.ok(teacher.deleteByID(teacherID));
	}
	
	@DeleteMapping("/student/{studentID}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long studentID){
		System.out.println("to delete "+studentID);
		return ResponseEntity.ok(student.deleteByID(studentID));
	}
	
	@DeleteMapping("/course/{CourseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable @NotNull Long CourseId)
	{
		System.out.println("in delete Courese " + CourseId);
		return ResponseEntity.ok(teacher.deleteCourseById(CourseId));
	}
	
	@DeleteMapping("/course/content/{contentId}")  // deleting the co
	public ResponseEntity<?> deleteContentById(@PathVariable @NotNull Long contentId)
	{
		System.out.println("in get delete by course id" + contentId);
		return ResponseEntity.ok(content.deleteByCourseId(contentId));
	}
	
	@GetMapping("/enrollment/day")                // getting all the count of enrollments done per days
	public ResponseEntity<?> countOfEnrollmentPerDay()
	{
		return ResponseEntity.ok(student.countEnrollsPerDay());
	}
	
	@GetMapping("/enrollment/teacher")
	public ResponseEntity<?> countEnrollsPerTeacher()
	{
		return ResponseEntity.ok(student.countEnrollForTeachers());
	}
	
}
