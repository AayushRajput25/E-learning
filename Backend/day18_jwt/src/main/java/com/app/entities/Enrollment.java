package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "enrollment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enrollment_id")
	private Long id;
	
	@Column(name = "enrollment_date")
	private LocalDate enrollmentDate = LocalDate.now();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id",nullable = false)
	private Courses cid;
	
	@ManyToOne
	@JoinColumn(name = "student_id",nullable = false)
	private Students sid;

	public Enrollment(Courses cid, Students sid) {
		super();
		this.cid = cid;
		this.sid = sid;
	}
	
	
	
}
