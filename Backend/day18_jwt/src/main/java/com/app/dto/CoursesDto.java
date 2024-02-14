package com.app.dto;

import org.hibernate.validator.constraints.Length;

import com.app.entities.Teachers;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CoursesDto {
	
	@Length(max = 100)
	private String courseName;

	
//	@JsonProperty(access = Access.READ_ONLY)
//	private Teachers tId;
//	
}
