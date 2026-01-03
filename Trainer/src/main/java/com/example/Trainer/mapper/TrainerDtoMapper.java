package com.example.Trainer.mapper;

import com.example.Trainer.dto.TrainerRequest;
import com.example.Trainer.dto.TrainerResponse;
import com.example.Trainer.entity.Trainer;

public class TrainerDtoMapper {

	public static Trainer toEntity(TrainerRequest dto) {
		Trainer t = new Trainer();
		
		t.setName(dto.getName());
		t.setEmail(dto.getEmail());
		t.setExpertise(dto.getExpertise());
		t.setExperienceYears(dto.getExperienceYears());
		return t;
	}

	public static TrainerResponse toDto(Trainer t) {
		TrainerResponse response = new TrainerResponse();
		response.setId(t.getId());
		response.setName(t.getName());
		response.setEmail(t.getEmail());
		response.setExpertise(t.getExpertise());
		response.setExperienceYears(t.getExperienceYears());
		return response;
	}
}
