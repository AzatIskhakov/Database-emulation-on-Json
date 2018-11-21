package com.study.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.study.model.Book;
import com.study.model.Margins;
import com.study.writeutils.JsonBWriter;
import com.study.writeutils.TypeSelector;

public class BookDao extends AbstractDao<Book> {
	
	private String fileSource = "books.json";

	@Override
	public void update(long id, Book bookToUpdate) {

		List<Book> books = new ArrayList<>(getAll());
		books.stream().filter(book -> book.getId() == id).forEach(book -> {
			book.setName(bookToUpdate.getName());
			book.setReaderReserved(bookToUpdate.getReaderReserved());
			book.setEdition(bookToUpdate.getEdition());
			book.setDaysForLeasing(bookToUpdate.getDaysForLeasing());
		});
		
		try {
			FileOutputStream fos = new FileOutputStream(fileSource);
			TypeSelector<Book> b = new JsonBWriter();
			b.writeJsonStream(fos, books);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> select(Map<String, String> params) {
		String askedID = params.get(Margins.ID);
		String askedName = params.get(Margins.BOOK_NAME);
		String askedEdition = params.get(Margins.BOOK_EDITION);
		String askedLeasing = params.get(Margins.DAYS_LEASING);
		
		Stream<Book> bookStream = getAll().stream();
		
		if (!(askedID == null || askedID.isEmpty())) {
            long castedID = Long.valueOf(askedID);
            bookStream = bookStream.filter(book -> book.getId() == castedID);
        }

        if (!(askedName == null || askedName.isEmpty())) {
        	bookStream = bookStream.filter(book -> book.getName().toLowerCase().equals(askedName));
        }

        if (!(askedEdition == null || askedEdition.isEmpty())) {
            int castedEdition = Integer.valueOf(askedEdition);
            bookStream = bookStream.filter(book -> book.getEdition() == castedEdition);
        }

        if (!(askedLeasing == null || askedLeasing.isEmpty())) {
            int castedLeasing = Integer.valueOf(askedLeasing);
            bookStream = bookStream.filter(book -> book.getDaysForLeasing() == castedLeasing);
        }
		return (List<Book>) bookStream.collect(Collectors.toSet());
	}
	
	@Override
	public List<Book> getAll() {
		List<Book> bookList = new ArrayList<>();
		File file = new File(fileSource);
		
		if (file.exists()) {
			try (FileInputStream fos = new FileInputStream(file)) {
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
