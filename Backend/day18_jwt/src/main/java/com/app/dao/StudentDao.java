package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Students;

public interface StudentDao extends JpaRepository<Students,Long>{

}
