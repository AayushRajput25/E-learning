package com.app.controller;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.ContentDescDto;
import com.app.dto.ContentGetDto;
import com.app.dto.CoursesDto;
import com.app.dto.StudentDetailDTO;
import com.app.dto.TeacherDetailResponseDto;
import com.app.entities.Content;
import com.app.entities.Courses;
import com.app.entities.Teachers;
import com.app.service.ContentService;
import com.app.service.TeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
@Validated
public class TeacherController {

	@Autowired
	private TeacherService teacher;
	
	@Autowired
	private ContentService course;
	
	
	
	
	@GetMapping (value = "/{teacherID}")
	public ResponseEntity<?> studentDetails(@PathVariable Long teacherID){
		System.out.println("in get Teacher"+teacherID);
		return ResponseEntity.ok(teacher.getDetailsByID(teacherID));
	}
	
	@PutMapping
	public ResponseEntity<?> updateDetails(@RequestBody TeacherDetailResponseDto teach){
		System.out.println("in update Teacher details"+ teach);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(teacher.editDetails(teach));
	}
	
	@DeleteMapping("/{teacherID}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long teacherID){
		System.out.println("to delete Teacher "+teacherID);
		return ResponseEntity.ok(teacher.deleteByID(teacherID));
	}
	
	@PostMapping("/course/{teacherId}")
	public ResponseEntity<?> addCourse(@PathVariable Long teacherId,@RequestBody CoursesDto course){
		
		System.out.println("in add course"+course);
		return ResponseEntity.status(HttpStatus.CREATED).body(teacher.newCourseByTID(teacherId,course));
	}
	
	
	@GetMapping("/course/{teacherId}")
	public ResponseEntity<?> getCourses(@PathVariable @NotNull Long teacherId)
	{
		System.out.println("in get courser" + teacherId);
		return ResponseEntity.ok(teacher.getCoursesById(teacherId));
	}
	
	@DeleteMapping("/course/{CourseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable @NotNull Long CourseId)
	{
		System.out.println("in delete Courese " + CourseId);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(teacher.deleteCourseById(CourseId));
	}
	
	@PostMapping("/course/content/{CourseId}")
	public ResponseEntity<?> addContents(@PathVariable @NotNull Long CourseId,@RequestBody ContentDescDto content)
	{
		System.out.println("in add course"+content + CourseId);
		return ResponseEntity.status(HttpStatus.CREATED).body(course.newContentByCId(CourseId,content));
	
	}
	
	@PostMapping(value = "/course/content/video/{contentId}",consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image")MultipartFile file,@PathVariable Long contentId) throws IOException, java.io.IOException {
		ApiResponse uploadImage = course.uploadImageToFileSystem(file,contentId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}
	
	@GetMapping("/course/content/{contentId}")
	public ResponseEntity<ContentGetDto> coureseContentById(@PathVariable @NotNull Long contentId)
	{
		System.out.println("in Get Content"+ contentId);
		return ResponseEntity.ok(course.contentBYId(contentId));
	}
	
	
	
	
}
