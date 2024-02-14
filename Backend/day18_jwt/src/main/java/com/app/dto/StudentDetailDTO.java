package com.app.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.app.entities.Gender;
import com.app.entities.UserEntity;
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
public class StudentDetailDTO {
	
//	@JsonProperty(access = Access.READ_ONLY)
	private Long Id;
	
	@NotBlank(message = "Name required")
	private String name;
	
	@NotNull(message = "Age cannot be null")
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	@Length(max=10)
	private Gender gender;
	
	@Length(max=12)
	private String phoneNo;
	
	@Length(max=200)
	private String address;
	
}
