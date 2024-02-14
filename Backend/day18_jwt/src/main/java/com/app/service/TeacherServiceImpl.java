package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CourseDao;
import com.app.dao.TeacherDao;
import com.app.dto.ApiResponse;
import com.app.dto.CoursesDto;
import com.app.entities.Courses;
import com.app.entities.Teachers;

@Service
@Transactional

public class TeacherServiceImpl implements TeacherService {

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

}
