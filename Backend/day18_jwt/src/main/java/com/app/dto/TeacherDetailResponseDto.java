package com.app.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.app.entities.Gender;
import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TeacherDetailResponseDto {

	
	private Long id;
	
	@NotBlank
	@Length(max = 50)
	private String name;
	
	@NotNull
	private Integer age;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Length(max = 12)
	@NotBlank
	private String phoneNo;

//	@Lob
//	private byte[] profilePic;

	@NotBlank
	private String degree;

	@NotBlank
	private String specialization;

	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private UserRole role;





}
