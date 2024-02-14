package com.app.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CourseDao;
import com.app.dao.TeacherDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ApiResponse;
import com.app.dto.CoursesDto;
import com.app.dto.TeacherDetailResponseDto;
import com.app.entities.Courses;
import com.app.entities.Teachers;
import com.app.entities.UserEntity;

@Service
@Transactional

public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private UserEntityDao uDao;
	
	@Autowired
	private TeacherDao tDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CourseDao cDao;
	
	@Override
	public ApiResponse newCourseByTID(Long teacherId, CoursesDto course) {
		
		Teachers t = tDao.findById(teacherId).orElseThrow(()-> new ResourceNotFoundException("Invalid Teacher"));
		
		Courses c = mapper.map(course, Courses.class);
		t.addCourse(c);
		cDao.save(c);
		return new ApiResponse("Added successfully");
	}

	@Override
	public List<Courses> getAllCourses() {
		   
		return cDao.findAll();
	}

	@Override
	public List<Courses> getCoursesById(@NotNull Long teacherId) {
		
		
		Teachers t = tDao.getById(teacherId);
		return cDao.findkarleBhai(t);
	}

	@Override
	public ApiResponse deleteCourseById(@NotNull Long CourseId) {
		
		if (cDao.existsById(CourseId)) {
			cDao.deleteById(CourseId);
			return new ApiResponse("Deleted Succesfully");
		}
		return new ApiResponse("Deletion failed");
	}

	@Override
	public TeacherDetailResponseDto getDetailsByID(Long teacherID) {
		UserEntity u = uDao.findById(teacherID).orElseThrow(()-> new ResourceNotFoundException("teacher Not found"));
		Teachers t = tDao.findById(teacherID).orElseThrow(()-> new ResourceNotFoundException("teacher Not found"));
		
		TeacherDetailResponseDto response = mapper.map(t,TeacherDetailResponseDto.class);
		response.setRole(u.getRole());
		
		return response;
	}

	@Override
	public ApiResponse editDetails(TeacherDetailResponseDto teach) {
		if (tDao.existsById(teach.getId())) {
		Teachers t = tDao.findById(teach.getId()).orElseThrow(()-> new ResourceNotFoundException("teacher Not found"));
	 	t =  mapper.map(teach,Teachers.class);
		tDao.save(t);
		return new ApiResponse("Updated Successesfully");	
		}	
		return new ApiResponse("Update Failed");
	}

	@Override
	public ApiResponse deleteByID(Long teacherID) {
		
		if (tDao.existsById(teacherID)) {
			tDao.deleteById(teacherID);
			return new ApiResponse("deleted succesfully");
		}
		return new ApiResponse("deletion failed");
	}

	
	
	
	
}
