package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entities.Gender;
import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserDetailDto {

	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	@NotBlank(message = "Name required")
	private String name;

	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String phoneNo;
	
	@Email(message = "Invalid Email!!!")
	private String email;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private UserRole role = UserRole.STUDENT;
	
	private String address;
	
}
