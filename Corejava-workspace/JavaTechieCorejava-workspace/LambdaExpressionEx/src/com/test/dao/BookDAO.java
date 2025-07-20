package com.test.dao;

import java.util.Arrays;
import java.util.List;

import com.test.Book;

public class BookDAO {

	public List<Book> getBooks() {
		List<Book> books = Arrays.asList(new Book(1, "Java", 400), 
				new Book(2, "SpringBoot", 500),
				new Book(3, "Hibernate", 450),
				new Book(4, "Core Java", 550));
		return books;
	}
}
