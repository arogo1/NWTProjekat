package com.example.microserviceinquiry;

import com.example.microserviceinquiry.Models.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private InquiryController inquiryController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception{
	}

	@Test
	void createInquiryWith() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.post("/saveInquiry")
			.content(asJsonString(new Inquiry(1, 1, "Test", 1, null)))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	@Test
	void getInquiryByIdError() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.get("/getInquiryById"))
			.andExpect(status().isNotFound());
	}

	@Test
	void getInquiryById() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.get("/getInquiryById/1"))
			.andExpect(status().isOk());
	}

	@Test
	void getInquiryByNameError() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.get("/getInquiryByName"))
			.andExpect(status().isNotFound());
	}

	@Test
	void getInquiryByName() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.get("/getInquiryByName/Test"))
			.andExpect(status().isOk());
	}

	@Test
	void getInquiryByNameError2() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.get("/getInquiryByName/sadfaf"))
			.andExpect(status().isOk());
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
