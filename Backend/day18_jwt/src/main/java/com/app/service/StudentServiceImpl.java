package com.app.service;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.StudentDao;
import com.app.dto.ApiResponse;
import com.app.dto.StudentDetailDTO;
import com.app.entities.Students;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao dao;
	
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
		return mapper.map(dao.findById(studentID).orElseThrow(()-> new ResourceNotFoundException("Invalid Student Id")),StudentDetailDTO.class);
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
		if(dao.existsById(studentID)) {
			dao.deleteById(studentID);
			return new ApiResponse("deleted succesfully");
		}
		return new ApiResponse("deletion failed");
	}
	

}
