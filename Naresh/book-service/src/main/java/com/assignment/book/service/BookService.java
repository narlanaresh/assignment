package com.assignment.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.book.entity.Book;
import com.assignment.book.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book saveBook(Book book) {
		log.info("this is save method of service class");
		return bookRepository.save(book);
	}

	
	public Book getBook(Long  bookId) {
		log.info("this is getBook method of service class");
		return bookRepository.findByBookId(bookId);
	}
}
