package com.assignment.book;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.assignment.book.entity.Book;
import com.assignment.book.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@RunWith(SpringRunner.class)
class BookServiceApplicationTests {

	
	
	
	@Autowired
	private WebApplicationContext context;
	@Mock
	private BookService service;
	
	
	ObjectMapper om = new ObjectMapper();
	private MockMvc mockMvc=null;
	@BeforeEach
	private void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	
	
	@Test
	public void createBook() throws Exception {
		Book  book=new Book();
		book.setBookId(1L);
		book.setAuthor("Java");
		String jsonRequest = om.writeValueAsString(book);
		MvcResult result = mockMvc.perform(post("/books/").content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Book response = om.readValue(resultContent, Book.class);
		Assert.assertTrue(response.getBookId() == 1);
		
	}
	
	
	
}
