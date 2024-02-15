package com.app.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CourseDao;
import com.app.dao.EnrollmentDao;
import com.app.dao.TeacherDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ApiResponse;
import com.app.dto.CoursesDto;
import com.app.dto.EditCourseDto;
import com.app.dto.StudentByTId;
import com.app.dto.TeacherDetailResponseDto;
import com.app.entities.Courses;
import com.app.entities.Students;
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

	@Autowired
	private EnrollmentDao eDao;
	
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
		
		if (tDao.existsById(teacherID) && uDao.existsById(teacherID)) {
			tDao.deleteById(teacherID);
			uDao.deleteById(teacherID);
			return new ApiResponse("deleted succesfully");
		}
		return new ApiResponse("deletion failed");
	}

	@Override
	public List<StudentByTId> studentsForTeachers(@NotNull Long teacherId) {
		
		
		return eDao.studentEnrolled(teacherId);
	}

	@Override
	public List<TeacherDetailResponseDto> getAllTeachers() { // to get all teachers registed for admin
		
//		List<TeacherDetailResponseDto> result = null;
		List<Teachers> reslist = tDao.findAll();
//		if (reslist != null) {
//			
//			for (Teachers t : reslist) {
//				
//				result.add(mapper.map(t, TeacherDetailResponseDto.class));
//			}
//			return result;
//		}
//		
		List<TeacherDetailResponseDto> entityToDto = mapper.map(reslist, new TypeToken<List<TeacherDetailResponseDto>>(){}.getType());
		return entityToDto;
	}

	@Override
	public ApiResponse uploadImage(Long teacherId, MultipartFile image) throws IOException {  // tp post profile pic
		// get teacher from teacher id
		Teachers t= tDao.findById(teacherId).
				orElseThrow();
		// teacher found --> PERSISTENT
		// to store the img directly in DB as a BLOB
		t.setProfilePic(image.getBytes());
		tDao.save(t);
		return new ApiResponse("image saved successfull for "+teacherId);
	}

	@Override
	public byte[] downloadImage(Long teacherId) throws IOException {  // to get the profile pic in image form
		// get teacher by id
				Teachers t = tDao.findById(teacherId).orElseThrow();
				// teacher found --> PERSISTENT
				return t.getProfilePic();
			}

	@Override
	public ApiResponse editContentByTID(@NotNull Long teacherId, @Valid EditCourseDto course) { // updating courses 
		if(cDao.existsById(course.getId()))
		{
			Courses c = mapper.map(course, Courses.class);
			Teachers t = tDao.getById(teacherId);
			c.setTId(t);
			cDao.save(c);
			return new ApiResponse("content have been updated");
		}
			
		return new  ApiResponse("updation failed");
	}

	
	
	
}
