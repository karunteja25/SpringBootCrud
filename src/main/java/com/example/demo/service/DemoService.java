package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.dto.UserDTO;

public interface DemoService {
	
	public String testAPI();
	public UserDTO saveUser(UserDTO userDto);
	public UserDTO findUserById(Integer id) throws Exception;
    public UserDTO updateUser(UserDTO userDto);
    public String removeUserById(Integer id);
    public List<UserDTO> getAllUsers();
    public UserDTO findUserByName(String userName);
    public UserDTO updateUserNameById(String userName,Integer id);
    public List<UserDTO> displayUserStats() throws SQLException;

}
