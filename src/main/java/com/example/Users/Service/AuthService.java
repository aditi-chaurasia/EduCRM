package com.example.Users.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Users.DTO.LoginRequest;
import com.example.Users.DTO.RequestDTO;
import com.example.Users.DTO.ResponseDTO;
import com.example.Users.Entity.User;
import com.example.Users.Entity.User.Role;
import com.example.Users.Mapper.UserMapper;
import com.example.Users.Respository.UserRepository;
import com.example.Users.Security.JwtUtil;

import jakarta.annotation.PostConstruct;

@Service
public class AuthService {
 
    @Autowired
    private UserRepository userRepository;
 
    @Autowired
    private JwtUtil jwtUtil;
 
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    public ResponseDTO login(LoginRequest request) {
 
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
 
        if (!passwordEncoder.matches(
                request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
 
        String token = jwtUtil.generateToken(user);
 
        return new ResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                null,
                "Login successful",
                token,
                user.getRole().name()
        );
    }
 
    public ResponseDTO register(RequestDTO request) {
 
        User user = UserMapper.fromDTOToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
 
        userRepository.save(user);
 
        return new ResponseDTO(
                null,
                user.getName(),
                user.getEmail(),
                null,
                "User registered successfully",
                null,
                user.getRole().name()
        );
    }
    
    @PostConstruct
    public void createSuperAdmin() {
     
        String adminEmail = "admin@educrm.com";
     
        if (!userRepository.existsByEmail(adminEmail)) {
     
            User admin = new User();
            admin.setName("Super Admin");
            admin.setEmail(adminEmail);
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Role.ADMIN);
     
            userRepository.save(admin);
     
            System.out.println("Super Admin created");
        }
    }
    
    public ResponseDTO registerAdmin(RequestDTO request) {
    	 
        User user = UserMapper.fromDTOToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ADMIN);
 
        userRepository.save(user);
 
        return new ResponseDTO(
                null,
                user.getName(),
                user.getEmail(),
                null,
                "Admin created successfully",
                null,
                Role.ADMIN.name()
        );
    }
    public ResponseDTO registerTrainer(RequestDTO request) {
   	 
        User user = UserMapper.fromDTOToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.TRAINER);
 
        userRepository.save(user);
 
        return new ResponseDTO(
                null,
                user.getName(),
                user.getEmail(),
                null,
                "Trainer created successfully",
                null,
                Role.TRAINER.name()
        );
    }
}

 
