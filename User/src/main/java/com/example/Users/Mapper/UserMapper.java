package com.example.Users.Mapper;

import com.example.Users.DTO.RequestDTO;
import com.example.Users.DTO.ResponseDTO;
import com.example.Users.Entity.User;
import com.example.Users.Entity.User.Role;

public class UserMapper {
public static User fromDTOToEntity(RequestDTO dto)
{
	User u= new User();
	u.setName(dto.getName());
	u.setEmail(dto.getEmail());
    u.setRole(Role.USER);
	u.setPassword(dto.getPassword());
	return u;
}

public static ResponseDTO fromEntityToDTO(User u)
{
	ResponseDTO dto=new ResponseDTO();
	dto.setName(u.getName());
	dto.setEmail(u.getEmail());
    dto.setRole(u.getRole().name());
	dto.setPassword(u.getPassword());
	return dto;
}
}
