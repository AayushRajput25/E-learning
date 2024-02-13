package com.app.entities;

import javax.persistence.*;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.JoinColumn;
//import javax.persistence.Lob;
//import javax.persistence.MapsId;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teachers extends BaseEntity{

	@Column(length = 50)
	private String name;
	
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Gender gender;
	
	@Column(length = 15)
	private String phoneNo;
	
	@Column(length = 200)
	private String address;
	
	@Lob
	private byte[] profilePic;
	
	@Column(length = 50)
	private String degree;
	
	@Column(length = 100)
	private String specialization;
	
	@OneToOne
	@JoinColumn(name = "teachers_id",nullable = false)
	@MapsId
	private UserEntity tId;
	
}
