package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courses extends BaseEntity{

	@Column(length = 100)
	private String courseName;
	
	@Column(length = 4000)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Teacher_Id",nullable = false)
	@JsonIgnore
	private Teachers tId;
	
	@OneToMany(mappedBy = "cId"/*, cascade = CascadeType.MERGE*/,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Content> content = new ArrayList<>();
	
	 // helper method : to add course
 	public void addCourse(Content c) {		
 		this.content.add(c);// can navigate from parent --> child
 		c.setCId(this);// can navigate from child --> parent
 	}

 	// helper method : to remove course
 	public void removeCourse(Content c) {
 		this.content.remove(c);
 		c.setCId(null);
 	}
	
}
