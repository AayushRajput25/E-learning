package com.app.service;

import java.io.IOException;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CourseDao;
import com.app.dao.EnrollmentDao;
import com.app.dao.StudentDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ApiResponse;
import com.app.dto.StudentDetailDTO;
import com.app.dto.TeacherDetailResponseDto;
import com.app.dto.EnrolledCoursesDto;
import com.app.entities.Courses;
import com.app.entities.Enrollment;
import com.app.entities.Students;
import com.app.entities.Teachers;
import com.app.entities.UserEntity;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private UserEntityDao uDao;
	
	@Autowired
	private StudentDao dao;
	
	@Autowired
	private EnrollmentDao eDao;
	
	@Autowired
	private CourseDao cDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public String uploadImage(Long empId, MultipartFile image) throws IOException {
		// get emp from emp id
		Students stu = dao.findById(empId).
				orElseThrow();
		// emp found --> PERSISTENT
		// to store the img directly in DB as a BLOB
		stu.setProfilePic(image.getBytes());
		dao.save(stu);
		return ("Image file uploaded successfully for emp id " + empId);
	}


	@Override
	public byte[] downloadImage(Long empId) throws IOException {
		// get emp by id
		Students stu = dao.findById(empId).orElseThrow();
		// emp found --> PERSISTENT
		return stu.getProfilePic();
	}

	@Override
	public StudentDetailDTO getDetailsByID(long studentID) {
		UserEntity u = uDao.findById(studentID).orElseThrow(()-> new ResourceNotFoundException("student Not found"));
		Students s = dao.findById(studentID).orElseThrow(()-> new ResourceNotFoundException("student Not found"));
		StudentDetailDTO res = mapper.map(s, StudentDetailDTO.class);
		res.setRole(u.getRole());
//		System.out.println(res.toString());
		return res;
	}

	@Override
	public StudentDetailDTO editDetails(StudentDetailDTO stu) {
		
		Students student = mapper.map(stu, Students.class);
		// chk if emp exists
		if(dao.existsById(student.getId())) {//select
			Students s1 = dao.findById(student.getId()).orElseThrow(()-> new ResourceNotFoundException("Invalid Student Id"));
			s1.setAddress(student.getAddress());
			s1.setAge(student.getAge());
			s1.setGender(student.getGender());
			s1.setName(student.getName());
			s1.setPhoneNo(student.getPhoneNo());
			
			return mapper.map(dao.save(s1),StudentDetailDTO.class);
		}
		return null;
	}


	@Override
	public ApiResponse deleteByID(Long studentID) {
		if(dao.existsById(studentID) && uDao.existsById(studentID)) {
			dao.deleteById(studentID);
			uDao.deleteById(studentID);
			return new ApiResponse("deleted succesfully");
		}
		return new ApiResponse("deletion failed");
	}


	@Override
	public ApiResponse enrollByIds(@NotNull Long studentID, @NotNull Long courseID) {
		// TODO Auto-generated method stub
		Students s = dao.getById(studentID);
		Courses c = cDao.getById(courseID);
		if (s != null && c != null) {
			Enrollment e = new Enrollment(c,s);
			eDao.save(e);
			return new ApiResponse("Successfull Enrolled");
		}	
		
		return new ApiResponse("Failed to enroll");
	}

	@Override
	public List<EnrolledCoursesDto> getMyCourses(Long studentID) {
		
		Students s = dao.getById(studentID);	
		return eDao.findAllEnrolledCourses(s);
	}


	@Override
	public ApiResponse unenrollByID(@NotNull Long enrollmentId) {
		if (eDao.existsById(enrollmentId)) {
			eDao.deleteById(enrollmentId);
			return new ApiResponse("deleted Successfull");
		}
		return new ApiResponse("deletion failed");
	}
	
	@Override
	public List<StudentDetailDTO> getAllStudent() { // to get all teachers registed for admin
		
		List<Students> reslist = dao.findAll();
		
		List<StudentDetailDTO> entityToDto = mapper.map(reslist, new TypeToken<List<StudentDetailDTO>>(){}.getType());
		return entityToDto;
	}
	

}
