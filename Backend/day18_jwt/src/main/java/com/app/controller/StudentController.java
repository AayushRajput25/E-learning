package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.app.dto.StudentDetailDTO;
import com.app.dto.StudentSignUp;
import com.app.service.StudentService;

import io.jsonwebtoken.io.IOException;

@RestController
@RequestMapping("/student")
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
	@GetMapping (value = "/{studentID}")
	public ResponseEntity<?> studentDetails(@PathVariable Long studentID){
		System.out.println("in get Student"+studentID);
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
		
}
