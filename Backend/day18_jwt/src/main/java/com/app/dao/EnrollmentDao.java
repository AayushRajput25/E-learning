package com.app.dao;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.EnrolledCoursesDto;
import com.app.dto.StudentByTId;
import com.app.entities.Courses;
import com.app.entities.Enrollment;
import com.app.entities.Students;

public interface EnrollmentDao extends JpaRepository<Enrollment, Long>{

//	@Query("SELECT DISTINCT e FROM Courses e LEFT OUTER JOIN e.enrollmentNo t")
//	List<Enrollment> khojlebhai(Students s);

	@Query(value = "select course.id as id,course_name as cname,course.description as des, enrollment_id as eId from course ,enrollment where student_id = ?1 and enrollment.course_id = course.id;",nativeQuery = true)
	
//	@Query("SELECT DISTINCT e FROM Courses e LEFT OUTER JOIN e.enrollmentNo t")
	List<EnrolledCoursesDto> findAllEnrolledCourses(Students s);
//	
//    @Query("select e from Enrollment e where e.sid = 2")
//    List<Enrollment> findBy(Students s);

	@Query(value = "select students.name as name, enrollment.student_id as student_id, course.course_name as course_name from students, enrollment, course where students.student_id = enrollment.student_id and enrollment.course_id = course.id and course.teacher_id = ?1 ;",nativeQuery = true)
	List<StudentByTId> studentEnrolled(@NotNull Long teacherId);
	
}
