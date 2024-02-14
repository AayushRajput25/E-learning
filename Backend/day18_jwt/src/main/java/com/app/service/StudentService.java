package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDetailDTO;
import com.app.dto.StudentSignUp;
import com.app.entities.Students;

public interface StudentService {

	Object uploadImage(Long studentID, MultipartFile imageFile) throws IOException;

	byte[] downloadImage(Long studentID) throws IOException;

	StudentDetailDTO getDetailsByID(long studentID);

	StudentDetailDTO editDetails(StudentDetailDTO stu);

	ApiResponse deleteByID(Long studentID);

	
}
