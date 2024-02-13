package com.app.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.StudentDao;
import com.app.entities.Students;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao dao;
	

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


}
