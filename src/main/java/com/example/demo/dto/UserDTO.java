package com.example.demo.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserDTO {

	private Integer id;
	private String username;
	private Integer age;
	private String address;
}
