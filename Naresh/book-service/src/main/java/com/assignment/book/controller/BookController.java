package com.assignment.book.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.assignment.book.entity.Book;
import com.assignment.book.service.BookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	            
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/order")
	@HystrixCommand(fallbackMethod = "", commandProperties =   {
			@HystrixProperty(name =  "execution.isolation.thread.timeoutInMilliseconds", value =  "10000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10")
			 }
	)
	public String getOrderStatus() {
		log.info("this method for sample fallback method");
	
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8081/payment",
				String.class);
		return responseEntity.getBody();
	}

	public String defaultFunction() {
		return "Server is down, please try later!!";
	}
	
	@PostMapping("/")
	public Book saveBook(@RequestBody Book book) {
		log.info("this is save method of controller class");
		return bookService.saveBook(book);
		
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable("id") Long id) {
		log.info("this is getBook method of controller class");
		return bookService.getBook(id);
	}

}
