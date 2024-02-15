package com.app.service;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.StudentSignUp;
import com.app.dto.TeacherSignUp;
import com.app.dto.UserDetailDto;

public interface UserService {
//sign up
	StudentSignUp studentRegistration(StudentSignUp reqDTO);

	TeacherSignUp teacherRegistration(TeacherSignUp reqDTO);

	UserDetailDto getDetialByEmail(String email);
}
