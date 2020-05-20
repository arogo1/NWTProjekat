package com.example.microserviceuser;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.microserviceuser.models.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MicroserviceuserApplicationTests {
	
	@Autowired
    private MockMvc mvc;
	
	/*@Order(0)
	@Test
	public void saveUserTest() throws Exception
	{
		String json = "{\"username\":\"slekic1\",\"password\":\"Kolikomilki1.\"}";
		mvc.perform(MockMvcRequestBuilders.post("/user")
										  .contentType(MediaType.APPLICATION_JSON)
										  .content(json))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.username").value("slekic1"));

	}*/
	
	@Order(0)
	@Test
	void saveUserTest() throws Exception{
		ObjectMapper om = new ObjectMapper();
	    this.mvc.perform(post("/user")
	    	.content(om.writeValueAsString(new UserModel("noviTest","Kolikomilki12.")))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	/*
	@Test
	public void saveUserTest() throws Exception {
		String json = "{\"username\":\"slekic1\",\"password\":\"Kolikomilki1.\"}";
		ObjectMapper om = new ObjectMapper();
	    this.mvc.perform(post("/user")
	    .content(json)
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print()).andExpect(status().isOk())
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.username").value("slekic1"))
		.andExpect(jsonPath("$.password").value("Kolikomilki1."));
	}*/
	
	@Order(1)
	@Test
	public void findAllUsersTest() throws Exception {
		this.mvc.perform(get("/users")).andDo(print())
		
		.andExpect(status().isOk());
	}
	
	@Order(1)
	@Test
	public void findUserByIdTest() throws Exception {
		this.mvc.perform(get("/user/15")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;"))
		.andExpect(jsonPath("$").isNotEmpty());
	}
	
	@Test
	void findUserByIdError() throws Exception{
		mvc.perform(MockMvcRequestBuilders
			.get("/user/100"))
			.andExpect(status().isNotFound());
    }
	
	
	
	@Order(1)
	@Test
	public void updateUserTest() throws Exception {
		ObjectMapper om = new ObjectMapper();
	    this.mvc.perform(put("/user/15")
	    .content(om.writeValueAsString(new UserModel(15,"slekic1updateTest","Kolikomilki12.")))
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print())
	    .andExpect(status().isOk())
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.username").value("slekic1updateTest"))
		.andExpect(jsonPath("$.password").value("Kolikomilki12."));
	}
	
	
	@Test
	void deleteUserError() throws Exception{
		mvc.perform(MockMvcRequestBuilders
			.delete("/user"))
			.andExpect(status().isNotFound());
	}
	@Order(2)
	@Test
	public void deleteUserByIdTest() throws Exception {
	    this.mvc.perform(delete("/user/14")
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk()); 
	}
	
	@Order(3)
	@Test
	public void deleteAllUsersTest() throws Exception {
	    this.mvc.perform(delete("/deleteAll")
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk());  
	}
	
	
	
	
}
