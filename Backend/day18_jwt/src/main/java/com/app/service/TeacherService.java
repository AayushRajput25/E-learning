package com.app.service;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.CoursesDto;
import com.app.dto.EditCourseDto;
import com.app.dto.StudentByTId;
import com.app.dto.TeacherDetailResponseDto;
import com.app.entities.Courses;

public interface TeacherService {

	ApiResponse newCourseByTID(Long teacherId, CoursesDto course);

	List<Courses> getAllCourses();

	List<Courses> getCoursesById(@NotNull Long teacherId);

	ApiResponse deleteCourseById(@NotNull Long CourseId);

	TeacherDetailResponseDto getDetailsByID(Long teacherID);

	ApiResponse editDetails(TeacherDetailResponseDto teach);

	ApiResponse deleteByID(Long teacherID);

	List<StudentByTId> studentsForTeachers(@NotNull Long teacherId);

	List<TeacherDetailResponseDto> getAllTeachers(); // to get all teachers for admin

	ApiResponse uploadImage(Long teacherId, MultipartFile imageFile) throws IOException;

	byte[] downloadImage(Long teacherId) throws IOException;

	ApiResponse editContentByTID(@NotNull Long teacherId, @Valid EditCourseDto course);

}
