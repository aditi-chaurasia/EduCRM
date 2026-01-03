package com.example.Trainer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Trainer.dto.TrainerRequest;
import com.example.Trainer.dto.TrainerResponse;
import com.example.Trainer.service.TrainerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/trainers")
@RequiredArgsConstructor
@Tag(name = "Trainers")
public class TrainerController {

	private final TrainerService trainerService;

	@Operation(summary = "Create a trainer")
	@PostMapping
	public ResponseEntity<TrainerResponse> create(@Valid @RequestBody TrainerRequest request) {

		return new ResponseEntity<TrainerResponse>(trainerService.createTrainer(request), HttpStatus.CREATED);

	}

	@Operation(summary = "Get Trainer by Id")
	@GetMapping("/{id}")
	public ResponseEntity<TrainerResponse> getTrainerById(@PathVariable Long id) {
		if (trainerService.getTrainerById(id) != null) {
			return ResponseEntity.ok(trainerService.getTrainerById(id));
		}
		return ResponseEntity.notFound().build();

	}

	@Operation(summary = "Get all trainers")
	@GetMapping
	public ResponseEntity<List<TrainerResponse>> getAllTrainers() {
		List<TrainerResponse> list = trainerService.getTrainers();
		return ResponseEntity.ok(list);
	}
}
