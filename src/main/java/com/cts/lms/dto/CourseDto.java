package com.cts.lms.dto;

import org.springframework.context.support.StaticApplicationContext;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

	private Long id;

	private String courseName = null;

	@Min(value = 1)
	private int courseDuration;

	@NotBlank
	@Size(min = 100)
	private String courseDescription;

	@NotBlank
	private String technology;

	@NotBlank
	private String launchURL;
	
	
	

}
