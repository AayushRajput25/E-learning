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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	
	// check for get api for content id might broke due to cascading 
	@OneToMany(mappedBy = "cid" ,cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Content> content = new ArrayList<>();
	
	@OneToMany(mappedBy = "sid",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Enrollment> enrollmentNo;
	
	 // helper method : to add course
 	public void addCourse(Content c) {		
 		this.content.add(c);// can navigate from parent --> child
 		c.setCid(this);// can navigate from child --> parent
 	}

 	// helper method : to remove course
 	public void removeCourse(Content c) {
 		this.content.remove(c);
 		c.setCid(null);
 	}
 	
 // helper method : to add Enrollment
  	public void addCourse(Enrollment e) {		
  		this.enrollmentNo.add(e);// can navigate from parent --> child
  		e.setCid(this);// can navigate from child --> parent
  	}

  	// helper method : to remove Enrollment
  	public void removeCourse(Enrollment e) {
  		this.enrollmentNo.remove(e);
  		e.setCid(null);
  	}
 	
 	
 	
}
