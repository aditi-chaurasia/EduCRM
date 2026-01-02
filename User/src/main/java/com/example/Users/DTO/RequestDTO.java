package com.example.Users.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor

public class RequestDTO {
	@NotBlank
	private String name;
	@Email(message="email must be valid")
	@NotBlank(message="email must be valid")
	private String email;
	private String password;
	//private String role;
}
