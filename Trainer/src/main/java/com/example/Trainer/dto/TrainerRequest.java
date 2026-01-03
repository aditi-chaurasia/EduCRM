package com.example.Trainer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TrainerRequest {

	@NotBlank
	@Size(max = 100)
	private String name;

	@Email
	@Size(max = 150)
	private String email;

	@Size(max = 100)
	private String expertise;

	@Min(0)
	private Integer experienceYears;
}
