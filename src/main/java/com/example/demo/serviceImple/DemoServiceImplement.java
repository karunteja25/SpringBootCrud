package com.example.demo.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DemoService;
@Service
public class DemoServiceImplement implements DemoService {

    @Autowired
	private UserRepository userRepo;
	
	@Autowired
	public UserDTO userDto;
	@Override
	public String testAPI() {
		
		return "API is working";
	}
	@Override
	public UserDTO saveUser(UserDTO userDto) {
		
		UserEntity userEntity= new UserEntity();
		userEntity.setUsername(userDto.getUsername());
		userEntity.setAge(userDto.getAge());
		userEntity.setAddress(userDto.getAddress());
		
		userRepo.save(userEntity);
		userDto.setUsername(userEntity.getUsername());
		userDto.setId(userEntity.getId());
		userDto.setAge(userEntity.getAge());
		userDto.setAddress(userEntity.getAddress());
		return userDto;
	}
	@Override
	public UserDTO findUserById(Integer id) throws Exception {
		
		UserDTO userDTO= new UserDTO();
		Optional<UserEntity> opt=userRepo.findById(id);
		UserEntity user=null;
		if(opt != null) {
			 user=opt.get();
			 userDTO.setUsername(user.getUsername());
				userDTO.setAddress(user.getAddress());
				userDTO.setAge(user.getAge());
				userDTO.setId(user.getId());
				return userDTO;
		}
		else {
			throw new NotFoundException();
		}
		
	}
	
	@Override
	public UserDTO updateUser(UserDTO userDto) {
		Optional<UserEntity> opt=userRepo.findById(userDto.getId());
		UserEntity user=null;
		if(opt != null) {
			 user=opt.get();
		}
		user.setUsername(userDto.getUsername());
		user.setAge(userDto.getAge());
		user.setAddress(userDto.getAddress());
		userRepo.save(user);
		return userDto;
	}
	@Override
	public String removeUserById(Integer id) {
		
		userRepo.deleteById(id);
		return "User deleted successfully";
	}
	@Override
	public List<UserDTO> getAllUsers() {
		
		List<UserEntity> allUsers=userRepo.findAll();
		List<UserDTO> userDtoList = new ArrayList<>();
		
		UserEntity user=new UserEntity();
		for(int i=0;i<allUsers.size();i++)
		{
			UserDTO userDto = new UserDTO();
			user=allUsers.get(i); 
			userDto.setId(user.getId());
			 userDto.setUsername(user.getUsername());
			 userDto.setAge(user.getAge());
			 userDto.setAddress(user.getAddress());
			 userDtoList.add(userDto);
			
		}
		return userDtoList;
	}

}
