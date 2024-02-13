package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "secure_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password") // toString excluding password
public class UserEntity extends BaseEntity {
//	@Column(length = 20)
//	private String firstName;
//	@Column(length = 20)
//	private String lastName;
	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 300, nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;
//	@OneToOne(mappedBy = "sId",cascade = CascadeType.ALL)
//	private Students student;
//
//	@OneToOne(mappedBy = "tId",cascade = CascadeType.ALL)
//	private Teachers teacher;
//
//	@OneToOne(mappedBy = "aId",cascade = CascadeType.ALL)
//	private Admin admin;


}
