package com.study.writeutils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.google.gson.stream.JsonWriter;
import com.study.model.Book;

public class JsonBWriter implements TypeSelector<Book> {
	
	
	public void writeJsonStream(OutputStream out, List<Book> books) throws IOException {
	     JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
	     writer.setIndent("    ");
	     writeBooksArray(writer, books);
	     writer.close();
	   }
	
	public void writeBooksArray(JsonWriter writer, List<Book> books) throws IOException {
	     writer.beginArray();
	     for (Book book : books) {
	    	 writeBook(writer, book);
	     }
	     writer.endArray();
	   }
	
	public void writeBook(JsonWriter writer, Book book) throws IOException {
	     writer.beginObject();
	     writer.name("id").value(book.getId());
	     writer.name("name").value(book.getName());
	     writer.name("edition").value(book.getEdition());
	     writer.name("leasing").value(book.getDaysForLeasing());
	     writer.endObject();
	   }

}
