package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

	private Book book;

	@BeforeEach
	void setUp() throws Exception {
		book = new Book("El oso polar",
				new ArrayList<String>(Arrays.asList("Arthur", "César")),
				(new SimpleDateFormat("dd-mm-yyyy")).parse("04-03-2020"),
				"A great publisher",
				"Action",
				12345745,
				"estante");
	}
	
	@AfterEach
	void setOff() throws Exception {
		
	}

	@Test
	void testGetTitle() {
		assertEquals("El oso polar", book.getTitle());
	}
	
//	@Test
//	void testGetAuthors() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetEditionDate() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

		assertEquals("04-03-2020", dateFormat.format(book.getEditionDate()));
	}

	@Test
	void testGetPublisher() {
		
		assertEquals("A great publisher", book.getPublisher());
	}

	@Test
	void testGetGender() {
		assertEquals("Action", book.getGender());
	}

	@Test
	void testGetISBN() {
		assertEquals(12345745, book.getISBN());
	}

	@Test
	void testGetLocation() {
		assertEquals("estante", book.getLocation());
	}

	@Test
	void testGetStatus() {
		assertEquals(Status.LIBRARY, book.getStatus());
	}
	
	@Test
	void testSetTitle() {
		book.setTitle("El panda polar");
		assertEquals("El panda polar", book.getTitle());
	}

//	@Test
//	void testAddAuthor() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testRemoveAuthor() {
//		fail("Not yet implemented");
//	}

	@Test
	void testSetEditionDate() throws ParseException {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
    	book.setEditionDate(dateFormat.parse("01-01-2019"));
		assertEquals("01-01-2019", dateFormat.format(book.getEditionDate()));

	}

	@Test
	void testSetPublisher() {
		book.setPublisher("another Publisher");
		assertEquals("another Publisher", book.getPublisher());
	}

	@Test
	void testSetGender() {
		book.setGender("Misterio");
		assertEquals("Misterio", book.getGender());
	}

	@Test
	void testSetISBN() {
		book.setISBN(987654321);
		assertEquals(987654321, book.getISBN());
	}

	@Test
	void testSetLocation() {
		book.setLocation("Estante F, sala 20");
		assertEquals("Estante F, sala 20", book.getLocation());
	}

	@Test
	void testBorrow() {
		book.borrow();
		assertEquals(Status.BORROWED, book.getStatus());
	}

	
	@Test
	void testOnLibrary() {
		book.borrow();
		book.onLibrary();
		assertEquals(Status.LIBRARY, book.getStatus());
	}

	@Test
	void testToString() {
    	String template = """
			Title: El oso polar
			Author(s): Arthur, César
			Edition: 04-03-2020
			Publisher: A great publisher
			Gender: Action
			ISBN: 12345745
			Location: estante
			Status En Librería		
    			""";
		assertEquals(template, book.toString());
	}
	
	@Test
	void testGetStringStatus() {
		assertEquals("En Librería", book.getStringStatus());
	}


}
