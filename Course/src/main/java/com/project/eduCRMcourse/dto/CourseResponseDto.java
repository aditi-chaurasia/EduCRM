package com.project.eduCRMcourse.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CourseResponseDto {
	
	private Long id;
	
	private String title;
	
	private String description;
	
	private Double price;
	
	private TrainerDto trainer;
	
	private LocalDateTime updatedAt;
}
