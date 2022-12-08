package com.example.demo.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.demo.controller.DemoController;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.DemoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserAPITest {
	
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper=new ObjectMapper();
	ObjectWriter objectWriter=objectMapper.writer();
	
	@Mock
	private DemoService demoService;
	
	@InjectMocks
	private DemoController demoController;
	
	UserDTO user1=new UserDTO(1,"john",30,"abcd123",null);
	UserDTO user2=new UserDTO(2,"jimmy",20,"xyz456",null);
	UserDTO user3=new UserDTO(3,"micheal",32,"lmnop456",null);
	UserDTO user4=new UserDTO(4,"maya",25,"lalaland",null);
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(demoController).build();
	}
	
	@Test
	public void getAllUsersTest() throws Exception {
		List<UserDTO> users=new ArrayList<>(Arrays.asList(user1,user2,user3,user4));
		Mockito.when(demoService.getAllUsers()).thenReturn (users);
		
		mockMvc.perform(MockMvcRequestBuilders
					.get("/getallusers")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$.size()", is(4)))
					.andExpect(MockMvcResultMatchers.jsonPath("$[2].username", is("micheal")));
				
	
	}

}
