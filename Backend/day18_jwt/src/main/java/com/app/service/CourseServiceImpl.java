package com.app.service;


import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.file.Counters.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.entities.Courses;


@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao cDao;
	
	@Override
	public List<Courses> getAllCourses() {
		return cDao.findAll();
	}

}
