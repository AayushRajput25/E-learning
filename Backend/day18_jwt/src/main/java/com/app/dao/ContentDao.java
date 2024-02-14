package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Content;

public interface ContentDao extends JpaRepository<Content, Long>{

}
