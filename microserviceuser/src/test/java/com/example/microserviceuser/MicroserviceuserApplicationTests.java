package com.example.microserviceuser;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.example.microserviceuser.models.User;
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


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
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
	public void saveUserTest() throws Exception {
		ObjectMapper om = new ObjectMapper();
	    this.mvc.perform(post("/user")
	    .content(om.writeValueAsString(new User("slekicTest","Kolikomilki1.")))
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print()).andExpect(status().isOk())
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.username").value("slekicTest"))
		.andExpect(jsonPath("$.password").value("Kolikomilki1."));
	}
	
	@Order(1)
	@Test
	public void findAllUsersTest() throws Exception {
		this.mvc.perform(get("/users")).andDo(print())
		
		.andExpect(status().isOk());
	}
	
	@Order(1)
	@Test
	public void findUserByIdTest() throws Exception {
		this.mvc.perform(get("/user/12")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;"))
		.andExpect(jsonPath("$").isNotEmpty());
	}
	
	@Order(1)
	@Test
	public void updateUserTest() throws Exception {
		ObjectMapper om = new ObjectMapper();
	    this.mvc.perform(put("/user/12")
	    .content(om.writeValueAsString(new User(12,"slekic1promijeni","Kolikomilki11.")))
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print()).andExpect(status().isOk()) 
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.username").value("slekic1promijeni"))
		.andExpect(jsonPath("$.password").value("Kolikomilki11."));
	}
	
	@Order(1)
	@Test
	public void findUserByUsernameTest() throws Exception {
		this.mvc.perform(get("/user/find/?username=slekic3")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;"))
		.andExpect(jsonPath("$").isNotEmpty()); 
	}
	
	@Order(2)
	@Test
	public void deleteUserByIdTest() throws Exception {
	    this.mvc.perform(delete("/user/12")
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk());  //no content status
	}
	
	/*@Order(3)
	@Test
	public void deleteAllUsersTest() throws Exception {
	    this.mvc.perform(delete("/deleteAll")
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk());  //no content status
	}*/
	
	
}
