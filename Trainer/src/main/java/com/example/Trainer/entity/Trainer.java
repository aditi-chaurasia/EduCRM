
package com.example.Trainer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trainers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trainer_id", nullable = false, updatable = false)
	private Long id;

	@NotBlank
	@Size(max = 100)
	@Column(name = "trainer_name", nullable = false, length = 100)
	private String name;

	@Email
	@Size(max = 150)
	@Column(name = "email_id", unique = true, length = 150)
	private String email;

	@Size(max = 100)
	@Column(name = "expertise", length = 100)
	private String expertise;

	@Min(0)
	@Column(name = "experience_years")
	private Integer experienceYears;
}
