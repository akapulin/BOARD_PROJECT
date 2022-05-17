package com.board.subproject.web;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@SpringBootTest 
@AutoConfigureMockMvc
public class HelloControllerTest {
	
	//web api test
	@Autowired(required = true)
	private MockMvc mvc;
	
	@Test
	public void hello가_리턴된다() throws Exception {
		String hello = "hello";
		mvc.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string(hello));
	}
}
