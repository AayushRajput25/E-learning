package com.app.dao;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.AnalyticForTeacherDto;
import com.app.entities.Teachers;

public interface TeacherDao extends JpaRepository<Teachers,Long>{

	@Query(value = "select count(enrollment_id) count, course_name name from enrollment, course where course_id =course.id and course_id = any(select id from course where teacher_id =?1) group by course_id;"
			,nativeQuery = true)
	List<AnalyticForTeacherDto> getcountByCid(@NotNull Long teacherId);

}
