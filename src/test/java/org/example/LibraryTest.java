package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
	
		@Nested
		class LibraryTest2 {


			static Library library;
			static InputStream sysInBackup;

			@BeforeEach
			void setUp() throws Exception {
				library = new Library();
				//sysInBackup = System.in; // backup System.in to restore it later
				
				// Command lines
				
				String line2 = "El oso polar";
				String line3 = "2";
				String line4 = "César";
				String line5 = "Oscar";
				String line6 = "14-12-2022";
				String line7 = "A great publisher";
				String line8 = "Action";
				String line9 = "1234567890";
				String line10 = "Estante F, sala 20";
				
				
				ByteArrayInputStream in = new ByteArrayInputStream((
						line2 + System.lineSeparator() +
						line3 + System.lineSeparator() +
						line4 + System.lineSeparator() +
						line5 + System.lineSeparator() +
						line6 + System.lineSeparator() +
						line7 + System.lineSeparator() +
						line8 + System.lineSeparator() +
						line9 + System.lineSeparator() +
						line10 + System.lineSeparator() 
						).getBytes());
				System.setIn(in);

			}

			@Test
			void testAddBook() {
				Book book = library.addBook();
		    	String template = """
					Title: El oso polar
					Author(s): César, Oscar
					Edition: 14-12-2022
					Publisher: A great publisher
					Gender: Action
					ISBN: 1234567890
					Location: Estante F, sala 20
					Status En Librería		
		    			""";
		    	if (book == null) fail("No se creo libro");
		    	assertEquals(template, book.toString());
			}

		

	}
		
	/* @Nested
	class LibraryTest3 {
		static Library library;
		static InputStream sysInBackup;
		static ByteArrayInputStream in;
		static String line1;
		static String line2;
		static String line3;
		static String line4;
		static String line5;
		static String line6;
		static String line7;
		static String line8;
		static String line9;
		static String line10;
		static String line11;
		static String line12;
		static String line13;
		static String line14;
		static Book book1;
		@BeforeAll
		void setUp() throws Exception {
			library = new Library();
			//sysInBackup = System.in; // backup System.in to restore it later
			
			// Command lines
			

			line1 = "1";
			line2 = "El panda";
			line3 = "3";
			line4 = "12-12-2010";
			line5 = "4";
			line6 = "A new publisher";
			line7 = "5";
			line8 = "Mistery";
			line9 = "6";
			line10 = "12345754";
			line11 = "7";
			line12 = "Estante D, sala 20";
			line13 = "8";
			line14 = "9";


			
			
			in = new ByteArrayInputStream((
					line1 + System.lineSeparator() +
					line2 + System.lineSeparator() +
					line3 + System.lineSeparator() +
					line4 + System.lineSeparator() +
					line5 + System.lineSeparator() +
					line6 + System.lineSeparator() +
					line7 + System.lineSeparator() +
					line8 + System.lineSeparator() +
					line9 + System.lineSeparator() +
					line10 + System.lineSeparator() +
					line11 + System.lineSeparator() +
					line12 + System.lineSeparator() +
					line13 + System.lineSeparator() +
					line14 + System.lineSeparator()

					).getBytes());
			System.setIn(in);
			
			book1 = new Book("El oso polar",
					new ArrayList<String>(Arrays.asList("Arthur", "César")),
					(new SimpleDateFormat("dd-mm-yyyy")).parse("04-03-2020"),
					"A great publisher",
					"Action",
					12345745,
					"estante");
			
			library.addBook(book1);
		
	
		}
	
		@BeforeEach
		void setUpEach() throws ParseException {
			library.deleteBook(12345745);
			
			Book book2 = new Book("El oso polar",
					new ArrayList<String>(Arrays.asList("Arthur", "César")),
					(new SimpleDateFormat("dd-mm-yyyy")).parse("04-03-2020"),
					"A great publisher",
					"Action",
					12345745,
					"estante");
			
			library.addBook(book2);
		}
		
		@Test
		void testEditTitle() {
			Book book = library.editBook(12345745);
			assertEquals("El panda", book.getTitle());
		}
		
		@Test
		void testEditEditionDate() {
			Book book = library.editBook(12345745);
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

			assertEquals("12-12-2010", dateFormat.format(book.getEditionDate()));
		}
		@Test
		void testEditPublisher() {
			Book book = library.editBook(12345745);
			assertEquals("A new publisher", book.getPublisher());
		}
		@Test
		void testEditGender() {
			Book book = library.editBook(12345745);
			assertEquals("Mystery", book.getGender());
		}
		@Test
		void testEditISBN() {
			Book book = library.editBook(12345745);
			assertEquals(12345754, book.getISBN());
		}
		@Test
		void testEditLocation() {
			Book book = library.editBook(12345745);
			assertEquals("Estante D, sala 20", book.getLocation());
		}
		@Test
		void testBorrow() {
			Book book = library.editBook(12345745);
			assertEquals(Status.BORROWED, book.getStatus());
		}
		@Test
		void testRetrieve() {
			Book book = library.editBook(12345745);
			assertEquals(Status.LIBRARY, book.getStatus());
		}
	} */
}

