package com.example.mikroservisquiz;

import com.example.mikroservisquiz.conroller.donequiz.doneQuizController;
import com.example.mikroservisquiz.conroller.quiz.quizConroller;
import com.example.mikroservisquiz.models.DoneQuiz;
import com.example.mikroservisquiz.models.Quiz;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	quizConroller quizConroller;

	@Autowired
	doneQuizController doneQuiz;
	
	
	@Test
	void contextLoads() {
	}

	//get quiz by id
	@Test
	void getQuizByIdError() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.get("/quiz"))
			.andExpect(status().isNotFound());
    }
	
	//get quiz by id
    @Test
	void getQuizById() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.get("/quiz/1"))
			.andExpect(status().isOk());
	}

	// delete quiz
	@Test
	void deleteQuizError() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.delete("/deleteQuiz"))
			.andExpect(status().isOk());
	}

	//delete quiz
	@Test
	void deleteQuiz() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.delete("/deleteQuiz/16"))
			.andExpect(status().isOk());
	}

	@Test
	void getDoneQuizByIdError() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.get("/doneQuiz"))
			.andExpect(status().isNotFound());
	}
	
	@Test
	void getDoneQuizById() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.get("/doneQuiz/8"))
			.andExpect(status().isNotFound());
	}
	
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	void createQuiz() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.post("/createQuiz/2")
			.content(asJsonString(new Quiz(2, 0, 5)))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
	@Test
	void createDoneQuiz() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
			.post("/createDoneQuiz/2")
			.content(asJsonString(new DoneQuiz(2, 2)))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
    }
}
