package com.project.eduCRMcourse.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CourseRequestDto {
	
	@NotBlank
	@Size(max = 50)
	private String title;
	
	@Size(max = 200)
	private String description;
	
	@Positive
	private Double price;
	
	@NotNull
	private Long trainerId;
}
