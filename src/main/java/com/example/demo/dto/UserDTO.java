package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.entity.UserStats;

import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDTO {

	private Integer id;
	private String username;
	private Integer age;
	private String address;
	@Nullable
	private UserStats userStats;
}
