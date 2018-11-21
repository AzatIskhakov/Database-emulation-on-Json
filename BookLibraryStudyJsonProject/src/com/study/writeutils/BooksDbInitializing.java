package com.study.writeutils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.study.model.Book;

public class BooksDbInitializing {
	
	public static void initDB() {
		JsonBWriter jbwr = new JsonBWriter();
		List<Book> listOfBooks = new ArrayList<>();
		Book b1 = new Book(0, "Holy Bible", 1, 10);
		Book b2 = new Book(1, "Java programming", 3, 5);
		Book b3 = new Book(2, "Python for beginners", 4, 7);
		Book b4 = new Book(3, "Spring for professionals", 2, 20);
		Book b5 = new Book(4, "Hibernate for experts", 3, 15);
		Book b6 = new Book(5, "Just Git", 8, 1);
		Book b7 = new Book(6, "Maven. Taste magic!", 7, 7);
		Book b8 = new Book(7, "Apache Tomcat", 1, 2);
		Book b9 = new Book(8, "Introduction to Java", 8, 10);
		Book b10 = new Book(10, "OpenCV", 3, 12);
		
		listOfBooks.add(b1);
		listOfBooks.add(b2);
		listOfBooks.add(b3);
		listOfBooks.add(b4);
		listOfBooks.add(b5);
		listOfBooks.add(b6);
		listOfBooks.add(b7);
		listOfBooks.add(b8);
		listOfBooks.add(b9);
		listOfBooks.add(b10);
		
		try {
			FileOutputStream fos = new FileOutputStream("books.json");
			jbwr.writeJsonStream(fos, listOfBooks);
		} catch(FileNotFoundException fnfe) {
			 fnfe.printStackTrace(); 
	      } catch(IOException e) { 
	         e.printStackTrace();
	      } catch (IllegalStateException ise) {
	    	  ise.printStackTrace();
	      }
		
	}

}
