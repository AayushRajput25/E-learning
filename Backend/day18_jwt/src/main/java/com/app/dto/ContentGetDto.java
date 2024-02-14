package com.app.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Service
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Setter
public class ContentGetDto {

    @Length (max= 100)
    private String title;

    
    private String filePath;
   
    private String description;
	
	
}
