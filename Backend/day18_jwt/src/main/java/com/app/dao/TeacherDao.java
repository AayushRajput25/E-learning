package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Teachers;

public interface TeacherDao extends JpaRepository<Teachers,Long>{

}
