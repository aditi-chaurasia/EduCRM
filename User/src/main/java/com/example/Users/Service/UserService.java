package com.example.Users.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Users.DTO.RequestDTO;
import com.example.Users.DTO.ResponseDTO;
import com.example.Users.Entity.User;
import com.example.Users.Exception.UserNotFoundException;
import com.example.Users.Mapper.UserMapper;
import com.example.Users.Respository.UserRepository;

public class UserService {

@Autowired
private UserRepository userRepo;

public ResponseDTO create(RequestDTO dto)
{
	User u=UserMapper.fromDTOToEntity(dto);
	User savedUser=userRepo.save(u);
	return UserMapper.fromEntityToDTO(savedUser);
}
public List<ResponseDTO> getAll()
{
	List<User> u= userRepo.findAll();
	return u.stream().map(UserMapper::fromEntityToDTO).toList();
}
public ResponseDTO get(Long id) throws UserNotFoundException
{
	User u= userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User with this id is not found"));
	return UserMapper.fromEntityToDTO(u);
}
public void delete(Long id)
{
	if(id!=null && userRepo.existsById(id))
	{
	    userRepo.deleteById(id);
	}
}

}
