package com.example.Trainer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Trainer.dto.TrainerRequest;
import com.example.Trainer.dto.TrainerResponse;
import com.example.Trainer.entity.Trainer;
import com.example.Trainer.mapper.TrainerDtoMapper;
import com.example.Trainer.repository.TrainerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainerService {

	private final TrainerRepository trainerRepository;

	public TrainerResponse createTrainer(TrainerRequest request) {
		Trainer t = TrainerDtoMapper.toEntity(request);
		t = trainerRepository.save(t);
		return TrainerDtoMapper.toDto(t);
	}

	public TrainerResponse getTrainerById(Long id) {
		Trainer t = trainerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));
		return TrainerDtoMapper.toDto(t);
	}

	public List<TrainerResponse> getTrainers() {
		return trainerRepository.findAll().stream().map(TrainerDtoMapper::toDto).collect(Collectors.toList());
	}
}
