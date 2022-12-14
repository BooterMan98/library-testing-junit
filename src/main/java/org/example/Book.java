package org.example;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Book {
    private String title;
    private List<String> authors;
    private Date editionDate;
    private String publisher;
    private String gender;
    private Integer ISBN;
    private String location;
    private Status status;

    public Book(String title, List<String> authors, Date editionDate, String publisher, String gender, Integer ISBN, String location) {
    	this.title = title;
    	this.authors = new ArrayList<>(authors);;
    	this.editionDate = editionDate;
    	this.publisher = publisher;
    	this.gender = gender;
    	this.ISBN = ISBN;
    	this.location = location;
    	this.status = Status.LIBRARY;
	}
    // getters
    public String getTitle() {
        return title;
    }
    public String[] getAuthors() {
        return (String[]) authors.toArray();
    }
    public Date getEditionDate() {
        return editionDate;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getGender() {
        return gender;
    }
    public Integer getISBN() {
        return ISBN;
    }
    public String getLocation() {
        return location;
    }
    public Status getStatus() {
        return status;
    }
    public String getStringStatus() {
    	return status.toString();
    }
    
    
    // setters
    public void setTitle(String title) {
		this.title = title;
	}
    public void addAuthor(String author) {
    	this.authors.add(author);
    }
    public Integer removeAuthor(String author) {
    	int index = this.authors.indexOf(author);
    	if (index == -1) return -1;
    	this.authors.remove(index);
    	return 1;
    }
    public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}
    public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
    public void setGender(String gender) {
		this.gender = gender;
	}
    public void setISBN(Integer isbn) {
		this.ISBN = isbn;
	}
    public void setLocation(String location) {
		this.location = location;
	}
    public void borrow() {
    	this.status = Status.BORROWED;
    }
    public void onLibrary() {
    	this.status = Status.LIBRARY;
    }
    
    public String toString() {
    	String template = """
			Title: %s
			Author(s): %s
			Edition: %s
			Publisher: %s
			Gender: %s
			ISBN: %d
			Location: %s
			Status %s		
    			""";
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
    			String value = String.format( template ,this.title, String.join(", ", this.authors), dateFormat.format(this.editionDate), this.publisher, this.gender, this.ISBN, this.location, this.status);
    	return value;
    }
 }
