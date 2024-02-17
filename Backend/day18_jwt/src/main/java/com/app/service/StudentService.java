package com.app.service;

import java.io.IOException;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDetailDTO;
import com.app.dto.CountOfEnrolls;
import com.app.dto.EnrolledCoursesDto;
import com.app.dto.NoOfEnrollsPerTeachers;
import com.app.entities.Courses;
import com.app.entities.Enrollment;

public interface StudentService {

	Object uploadImage(Long studentID, MultipartFile imageFile) throws IOException;

	byte[] downloadImage(Long studentID) throws IOException;

	StudentDetailDTO getDetailsByID(long studentID);

	StudentDetailDTO editDetails(StudentDetailDTO stu);

	ApiResponse deleteByID(Long studentID);

	ApiResponse enrollByIds(@NotNull Long studentID, @NotNull Long courseID);

	List<EnrolledCoursesDto> getMyCourses(Long studentID);

	ApiResponse unenrollByID(@NotNull Long enrollmentId);

	List<StudentDetailDTO> getAllStudent();

	List<CountOfEnrolls> countEnrollsPerDay();

	List<NoOfEnrollsPerTeachers> countEnrollForTeachers();

	
}
