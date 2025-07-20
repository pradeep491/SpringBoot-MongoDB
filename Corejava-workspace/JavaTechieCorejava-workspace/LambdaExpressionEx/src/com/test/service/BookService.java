package com.test.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.test.Book;
import com.test.dao.BookDAO;

public class BookService {
	public List<Book> getBooksInSort() {
		List<Book> books = new BookDAO().getBooks();
		// Approach-1
		// Collections.sort(books, new MyComparator());

		// Approach-2
		/*
		 * Collections.sort(books, new Comparator<Book>() {
		 * 
		 * @Override public int compare(Book o1, Book o2) { return
		 * o1.getName().compareTo(o2.getName()); } });
		 */

		// Approach-3
		Collections.sort(books, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		return books;
	}

	public static void main(String[] args) {
		System.out.println(new BookService().getBooksInSort());
	}
}

//Approach-1
/*
 * class MyComparator implements Comparator<Book> {
 * 
 * @Override public int compare(Book o1, Book o2) { // TODO Auto-generated
 * method stub return o2.getName().compareTo(o1.getName()); }
 * 
 * }
 */