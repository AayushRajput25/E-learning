package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.CoursesDto;
import com.app.entities.Courses;

public interface TeacherService {

	ApiResponse newCourseByTID(Long teacherId, CoursesDto course);

	java.util.List<Courses> getAllCourses();

}
