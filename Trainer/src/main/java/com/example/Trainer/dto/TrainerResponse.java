package com.example.Trainer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainerResponse {
	private Long id;
	private String expertise;
	private Integer experienceYears;
	private String name;
	private String email;

}
