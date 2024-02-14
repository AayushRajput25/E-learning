package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "Teacher_Id",nullable = false)
	@JsonIgnore
	private Teachers tId;
	
}
