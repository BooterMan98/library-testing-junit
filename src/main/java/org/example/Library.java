package org.example;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Library {
	private List<Book> books;
	
	public Library() {
		// TODO Auto-generated constructor stub
		this.books = new ArrayList<>();
	}
	
	
	public Book[] findBookByTitle(String inputTitle) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book: books) {
			if (book.getTitle() == inputTitle) foundBooks.add(book);
		}
		return foundBooks.toArray(new Book[foundBooks.size()]);
	}
	public Book[] findBookByAuthor(String inputAuthor) {
		List<Book> foundBooks = new ArrayList<Book>();

		for (Book book: books) {
			String[] authors = book.getAuthors();
			for (String author: authors) {
				if (author == inputAuthor) foundBooks.add(book);
			}
		}
		return foundBooks.toArray(new Book[foundBooks.size()]);
		// TODO Return book
	}
	public Book findBookByISBN(Integer isbn) {
		for (Book book: books) {
			System.out.println(book.getISBN());
			Integer bookISBN = book.getISBN();
			if (bookISBN.equals(isbn)) return book;
		}
		return null;
		// TODO Return book
	}

	public void editBook(Integer isbn) {
		Integer command;
		Book book = this.findBookByISBN(isbn);
		if (book == null) return;
    	Scanner cnsl = new Scanner(System.in);


    	try {
    	command = Integer.parseInt( cnsl.nextLine());
    	} catch (NumberFormatException nfe) {
    		System.out.println("Comando no registrado, comience el proceso denuevo");
    		return;
    	}
    	switch (command) {
    	case 1: // Title
    		System.out.println("Insert the new title");

    		String title = cnsl.nextLine();
    		book.setTitle(title);
    		
    		break;
    	case 2: // authors
    		System.out.println("Do you want to ADD or REMOVE an author?");

    		String subCmd = cnsl.nextLine();
    		switch (subCmd.toLowerCase()) {
    		case "add":
        		System.out.println("Please insert the new author to add");

        		String author = cnsl.nextLine();
        		book.addAuthor(author);
    			break;
    		case "remove":
    			break;
    		default:
    			System.out.println("unknown input, try the process again");
    			break;
    		}
    		break;
    	case 3: // edition date
    		System.out.println("Insert publisher date (dd-MMM-yyyy)");

        	String stringDate = cnsl.nextLine();
        	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        	Date date;
        	try {
        	    //Parsing the String
        	    date = dateFormat.parse(stringDate);
        	} catch (ParseException e) {
        	    // TODO Auto-generated catch block
        	    e.printStackTrace();
        	    System.out.println("There was an error in the date, please do the process again");
        	    return;
        	}
        	book.setEditionDate(date);
    		break;
    	case 4: // publisher
    		System.out.println("Please insert the new publisher");

    		String publisher = cnsl.nextLine();
    		book.setPublisher(publisher);
    		break;
    	case 5:// Gender
    		System.out.println("Please insert the new gender");

    		String gender = cnsl.nextLine();
    		book.setGender(gender);
    		break;
    	case 6: // ISBN
        	try {
        		System.out.println("Please insert the new ISBN number");
            	command = Integer.parseInt( cnsl.nextLine());
            	} catch (NumberFormatException nfe) {
            		System.out.println("That wasn't a number, start again");
            		return;
            	}
    		break;
    	case 7: // location
    		System.out.println("Please insert the new location of the book");

    		String location = cnsl.nextLine();
    		book.setLocation(location);
    		break;
    	}
    	
	}
	
	public void deleteBook(Integer isbn) {
		Book book = this.findBookByISBN(isbn);
		if (book == null) return;
		int index = books.indexOf(book);
		books.remove(index);
	}
	
	public void borrowBook(Integer isbn) {
		Book book = this.findBookByISBN(isbn);
		if (book == null) return;

		book.borrow();
	}
	
	public void retrieveBook(Integer isbn) {
		Book book = this.findBookByISBN(isbn);
		if (book == null) return;

		book.onLibrary();
	}
	
	public void addBook() {
    	Scanner cnsl = new Scanner(System.in);
    	
    	if (cnsl == null) {
            System.out.println("No console available");
            return;
        }
		System.out.println("In order to add a new book, we need some details");
		System.out.println("Intert title: ");

		String title = cnsl.nextLine();
		Integer authorQty;
    	try {
    		System.out.println("Insert number of authors");

    	authorQty = Integer.parseInt( cnsl.nextLine());
    	} catch (NumberFormatException nfe) {
    		System.out.println("Not a number, try again");
    		return;
    	}
    	List<String> authors = new ArrayList<>();
    	for (Integer c = 0; c < authorQty; c++) {
    		System.out.printf("Insert author number %d\n", c + 1);

    		String author = cnsl.nextLine();
    		authors.add(author);
    	}
		System.out.println("Insert publisher date (dd-mm-yyyy)");

    	String stringDate = cnsl.nextLine();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
    	Date date;
    	try {
    	    //Parsing the String
    	    date = dateFormat.parse(stringDate);
    	} catch (ParseException e) {
    	    // TODO Auto-generated catch block
    	    e.printStackTrace();
    	    System.out.println("There was an error in the date, please do the process again");
    	    return;
    	}
		System.out.println("Intert publisher: ");

		String publisher = cnsl.nextLine();
		System.out.println("Intert gender: ");

		String gender = cnsl.nextLine();
		Integer isbn;
    	try {
    		System.out.println("Insert ISBN: ");

    	isbn = Integer.parseInt( cnsl.nextLine());
    	} catch (NumberFormatException nfe) {
    		System.out.println("Not a number, try again");
    		return;
    	}
		System.out.println("Intert location: ");

		String location = cnsl.nextLine();
		
		Book book = new Book(title, authors, date, publisher, gender, isbn, location);
		System.out.println(book.toString());
		this.books.add(book);
    	
	}
	
    public void addBook(Book book) {
    	this.books.add(book);
    }
	
}
