package com.example.Users.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ResponseDTO {
private Long id;
private String name;
private String email;
private String password;
private String message;
private String token;
private String role;
}
