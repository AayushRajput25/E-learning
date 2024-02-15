package com.app.dao;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Content;
import com.app.entities.Courses;

public interface ContentDao extends JpaRepository<Content, Long>{


//	@Query("select x from Content x where x.cId = :c")
//	List<Content> findPlease(Courses c);

	List<Content> findByCid(Courses c);

}
