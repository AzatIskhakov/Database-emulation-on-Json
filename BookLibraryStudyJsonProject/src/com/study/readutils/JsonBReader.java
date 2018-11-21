package com.study.readutils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;
import com.study.model.Book;
import com.study.model.Reader;

public class JsonBReader {
	
	public List<Book> readJsonStream(InputStream fis) throws IOException {
		JsonReader jreader = new JsonReader(new InputStreamReader(fis, "UTF-8"));
		try {
			return readBooksArray(jreader);
		} finally {
			jreader.close();
		}
	}
	
	public List<Book> readBooksArray(JsonReader jreader) throws IOException {
		List<Book> books = new ArrayList<Book>();
		
		jreader.beginArray();
		while(jreader.hasNext()) {
			books.add(readBook(jreader));
		}
		jreader.endArray();
		return books;
	}
	
	public Book readBook(JsonReader jreader) throws IOException {
		long id = -1;
		String bookname = null;
		int edition = -1;
		int leasing = -1;
		
		jreader.beginObject();
		while (jreader.hasNext()) {
			String name = jreader.nextName();
			
			if (name.equals("id")) {
				id = jreader.nextLong();
			} else if (name.equals("name")) {
				bookname = jreader.nextString();
			} else if (name.equals("edition")) {
				edition = jreader.nextInt();
			} else if (name.equals("leasing")) {
				leasing = jreader.nextInt();
			} else {
				jreader.skipValue();
			}
		}
		jreader.endObject();
		
		Book book = new Book(id, bookname, edition, leasing);
		return book;	
	}

}
