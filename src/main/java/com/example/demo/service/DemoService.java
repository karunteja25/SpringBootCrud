package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDTO;

public interface DemoService {
	
	public String testAPI();
	public UserDTO saveUser(UserDTO userDto);
	public UserDTO findUserById(Integer id) throws Exception;
    public UserDTO updateUser(UserDTO userDto);
    public String removeUserById(Integer id);
    public List<UserDTO> getAllUsers();

}
