package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTest {

	static Library library;
	static Book book;
	@BeforeAll
	static void setUp() throws Exception {
		library = new Library();
		book = new Book("El oso polar",
				new ArrayList<String>(Arrays.asList("Arthur", "César")),
				(new SimpleDateFormat("dd-mm-yyyy")).parse("04-03-2020"),
				"A great publisher",
				"Action",
				12345745,
				"estante");
		
		library.addBook(book);
	}

	

	@Test
	void testFindBookByTitle() {
		Book[] books = library.findBookByTitle("El oso polar");
		if (books.length == 0) fail("Book not found");
		assertEquals(book, books[0]);
	}

	@Test
	void testFindBookByAuthor() {
		Book[] books = library.findBookByAuthor("César");
		if (books.length == 0) fail("Book not found");
		assertEquals(book, books[0]);	}
		
	@Test
	void testFindBookByISBN() {
		Book book = library.findBookByISBN(12345745);
		assertEquals(this.book, book);
	}

}

