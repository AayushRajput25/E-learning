package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import javax.validation.constraints.NotNull;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDetailDTO;
import com.app.dto.StudentSignUp;
import com.app.service.StudentService;

import io.jsonwebtoken.io.IOException;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")

public class StudentController {

	@Autowired
	private StudentService student;
	
	@PostMapping(value="/images/{studentID}",consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(@PathVariable Long studentID, @RequestParam MultipartFile imageFile)
			throws IOException, java.io.IOException {
		System.out.println("in upload img " + studentID);
		return ResponseEntity.status(HttpStatus.CREATED).body(student.uploadImage(studentID, imageFile));
	}
	
	@GetMapping(value = "/images/{studentID}", produces = { IMAGE_GIF_VALUE, IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	public ResponseEntity<?> serveStudentImage(@PathVariable Long studentID) throws IOException, java.io.IOException {
		System.out.println("in download img " + studentID);
		return ResponseEntity.ok(student.downloadImage(studentID));
	}
	
//	@PreAuthorize("hasRole('STUDENT')")
	@GetMapping (value = "/{studentID}") // getting students by id
	public ResponseEntity<?> studentDetails(@PathVariable Long studentID){
		System.out.println("in get Student"+studentID);
//		System.out.println(auth.getPrincipal());						//getting email from jwt token
		return ResponseEntity.ok(student.getDetailsByID(studentID));
	}
		
	@PutMapping
	public ResponseEntity<?> updateDetails(@RequestBody StudentDetailDTO stu){
		System.out.println("in update student details"+ stu);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(student.editDetails(stu));
	}
	
	@DeleteMapping("/{studentID}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long studentID){
		System.out.println("to delete "+studentID);
		return ResponseEntity.ok(student.deleteByID(studentID));
	}
	
	@PostMapping("/enroll/{studentID}/{courseID}")
	public ResponseEntity<?> enrollInCourse(@PathVariable @NotNull Long studentID, @PathVariable @NotNull Long courseID)
	{
		System.out.println("enroll by StudentID ="+studentID + "CourseID ="+courseID);
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(student.enrollByIds(studentID,courseID));

		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponse("something went wrong"));
		}
	}
	
	@GetMapping("/enroll/{studentID}")
	public ResponseEntity<?> getMyCourses(@PathVariable Long studentID)
	{
		System.out.println("To get courses for "+ studentID);
		return ResponseEntity.ok(student.getMyCourses(studentID));
	}
	
	@DeleteMapping("/enroll/{enrollmentId}")
	public ResponseEntity<?> unenrollFromCourse(@PathVariable @NotNull Long enrollmentId)
	{
		System.out.println("To Unenroll from "+enrollmentId);
		return ResponseEntity.ok(student.unenrollByID(enrollmentId));
	}
}
