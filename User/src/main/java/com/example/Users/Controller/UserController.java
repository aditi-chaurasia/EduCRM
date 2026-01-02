package com.example.Users.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Users.DTO.LoginRequest;
import com.example.Users.DTO.RequestDTO;
import com.example.Users.DTO.ResponseDTO;
import com.example.Users.Exception.UserNotFoundException;
import com.example.Users.Security.JwtUtil;
import com.example.Users.Service.UserService;

import jakarta.validation.Valid;

@RequestMapping("/users")
public class UserController {

@Autowired
private UserService userService;

@Autowired
private JwtUtil jwtUtil;
@PostMapping
public ResponseEntity<ResponseDTO> create (@Valid @RequestBody RequestDTO dto)
{
	ResponseDTO userResponse=userService.create(dto);
	return ResponseEntity.status(201).body(userResponse);
}
@GetMapping
public ResponseEntity<List<ResponseDTO>> get()
{
	List<ResponseDTO>userResponse=userService.getAll();
	return ResponseEntity.status(200).body(userResponse);
}
@GetMapping("/{id}")
public ResponseEntity<ResponseDTO> getById(@PathVariable Long id) throws UserNotFoundException
{
	ResponseDTO userResponse=userService.get(id);
	return ResponseEntity.status(200).body(userResponse);
}

}
