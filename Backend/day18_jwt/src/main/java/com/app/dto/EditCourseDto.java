package com.app.dto;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class EditCourseDto {


	private Long id;
	
	@Length(max = 100)
	private String courseName;

	@Length(max = 4000)
	private String description;
	
	
	
}
