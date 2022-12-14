package org.example;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	

	
    public static void main(String[] args) {
    	Library library = new Library();
    	boolean willContinue = true;
        Scanner cnsl = new Scanner(System.in);
    	Book[] foundBooks;
    	
    	if (cnsl == null) {
            System.out.println("No console available");
            return;
        }
    	System.out.println("Welcome to the library");
    	System.out.println("Add books to the library, change them, book them, and even remove them from the library");
    	
    	while (willContinue) {
        	System.out.println("Insert a new command: ");

    		String strung = cnsl.nextLine();
    		String[] command = strung.split(" ");
    		switch (command[0].toLowerCase()) {
    		case "add":
    			library.addBook();
    		 	break;
    		case "edit":
	 			try {
	 				Integer isbn = Integer.parseInt(command[2]);
	 				library.editBook(isbn);
	 			} catch (NumberFormatException nfe) {
	 				System.out.println("Bad argument");

	 			}
    		 	break;
    	 	case "remove":
	 			try {
	 				Integer isbn = Integer.parseInt(command[2]);
	 				library.deleteBook(isbn);
	 			} catch (NumberFormatException nfe) {
	 				System.out.println("Bad argument");

	 			}
    			 break;
    	 	case "find":
    	 		switch (command[1].toLowerCase()) {
    	 		case "title":
    	 			List<String> title = Arrays.asList(command);
    	 			title.remove(0);
    	 			foundBooks = library.findBookByTitle(String.join(" ", title));
    	 			break;
    	 		case "author":
    	 			List<String> posibleAuthor = Arrays.asList(command);
    	 			posibleAuthor.remove(0);
    	 			foundBooks = library.findBookByAuthor(String.join(" ", posibleAuthor));
	 				System.out.println(foundBooks.toString());
    	 			break;
    	 		case "isbn":
    	 			try {
    	 				Integer isbn = Integer.parseInt(command[2]);
    	 				Book book = library.findBookByISBN(isbn);
    	 				System.out.println(book.toString());
    	 			} catch (NumberFormatException nfe) {
    	 				System.out.println("Bad argument");
    	 			}
    	 			break;
    	 		}
    	 		break;
    	 	case "exit":
    	 		willContinue = false;
    	 		break;
    	 	default:
    	 		break;
    			 
    		 	
    		}
    	}
    	
    
    }
}