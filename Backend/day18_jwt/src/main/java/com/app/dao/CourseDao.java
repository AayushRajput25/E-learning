package com.app.dao;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.ApiResponse;
import com.app.dto.CountPerCourseNameDto;
import com.app.entities.Courses;
import com.app.entities.Teachers;

public interface CourseDao extends JpaRepository<Courses, Long>{

	//List<Courses> findByTId(Teachers t);

	@Query ("select c from Courses c where c.tId = :t")
	List<Courses> findkarleBhai(Teachers t);

	
	@Query(value = "select count(enrollment_id) as count, course_name as coursename from enrollment, course where course.id = enrollment.course_id group by course_name;",nativeQuery = true)
	List<CountPerCourseNameDto> countForCourse();
	
}
