package com.example.Users.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Users.DTO.LoginRequest;
import com.example.Users.DTO.RequestDTO;
import com.example.Users.DTO.ResponseDTO;
import com.example.Users.Service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
 
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(
            @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
 
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(
            @Valid @RequestBody RequestDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }

 // Only SUPER_ADMIN can create ADMIN
@PostMapping("/register-admin")
@PreAuthorize("hasRole('SUPER_ADMIN')")
public ResponseEntity<ResponseDTO> registerAdmin
(@Valid @RequestBody RequestDTO request) {
    return ResponseEntity.ok(authService.registerAdmin(request));
}

// Only ADMIN can create TRAINER
@PostMapping("/register-trainer")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<ResponseDTO> registerTrainer(@Valid @RequestBody RequestDTO request) {
    return ResponseEntity.ok(authService.registerTrainer(request));
}

//Only ADMIN can create USER (managed creation; optional if you want admins to create users)
 @PostMapping("/register-user")
 @PreAuthorize("hasRole('ADMIN')")
 public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody RequestDTO request) {
     return ResponseEntity.ok(authService.register(request));
 }

}