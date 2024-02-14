package com.app.dao;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.ApiResponse;
import com.app.entities.Courses;
import com.app.entities.Teachers;

public interface CourseDao extends JpaRepository<Courses, Long>{

	//List<Courses> findByTId(Teachers t);

	@Query ("select c from Courses c where c.tId = :t")
	List<Courses> findkarleBhai(Teachers t);
	
	
}
