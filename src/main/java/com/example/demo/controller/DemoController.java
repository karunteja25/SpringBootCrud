package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.DemoService;

@RestController
public class DemoController {
	
    @Autowired
	private DemoService dsi;
    
    public UserDTO userdto;
	
	@GetMapping(value = "/test", produces = "application/json")
	public ResponseEntity<String> testApi() {
		String dto =dsi.testAPI();
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	@PostMapping(value="/saveuser",produces = "application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userdto) {
		UserDTO user=dsi.saveUser(userdto);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	@PutMapping(value="/updateuser",produces="application/json")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto){
		UserDTO user=dsi.updateUser(userDto);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	@GetMapping(value = "/getallusers", produces = "application/json")
	public ResponseEntity<List<UserDTO>> findAllUsers() {
		List<UserDTO> dto =dsi.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	@DeleteMapping(value="/deleteuserbyid", produces = "application/json")
	public ResponseEntity<String> deleteUserById(@RequestBody Integer id){
	   String dto=dsi.removeUserById(id);
	   return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	@GetMapping(value = "/getuserbyid", produces = "application/json")
	public ResponseEntity<UserDTO> findUserById(@RequestBody Integer id) throws Exception {
		UserDTO dto =dsi.findUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	@GetMapping(value = "/getuserbyname", produces = "application/json")
	public ResponseEntity<UserDTO> findUserByName(@RequestBody String name) throws Exception {
		UserDTO dto =dsi.findUserByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	@PutMapping(value="/updateusernamebyid",produces="application/json")
	public ResponseEntity<UserDTO> updateNameById(@RequestBody UserDTO userDto){
		
		UserDTO user=dsi.updateUserNameById(userDto.getUsername(),userDto.getId());
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	@GetMapping(value="/displaystats",produces="application/json")
	public ResponseEntity<List<UserDTO>> displayUserStats() throws SQLException {
		List<UserDTO> dto =dsi.displayUserStats();
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	} 

}
