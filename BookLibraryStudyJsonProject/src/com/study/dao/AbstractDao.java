package com.study.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.google.gson.Gson;
import com.study.model.Book;
import com.study.model.Library;
import com.study.model.Reader;
import com.study.writeutils.JsonBWriter;
import com.study.writeutils.TypeSelector;

public abstract class AbstractDao<T> {
	
	private String fileSource;
	
	Gson gson = new Gson();
	
	public void insert(List<T> dataToInsert) throws FileNotFoundException {
		fileSource = getFileSource(dataToInsert);
		List<T> dataSet = new ArrayList<T>(getAll()); 
		TypeSelector<T> bk = null;
		
		if (!dataSet.contains(dataToInsert)) {
			
			try {
				FileOutputStream fos = new FileOutputStream(fileSource);
				bk.writeJsonStream(fos, dataToInsert);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getFileSource(List<T> dataToInsert) {
		if (dataToInsert instanceof Reader) {
			return "readers.json";
		}
		if (dataToInsert instanceof Book) {
			return "books.json";
		}
		if (dataToInsert instanceof Library) {
			return "libraries.json";
		}
		return "";
	}
	
	public abstract void update(long id, T dataToUpdate);
	
	public abstract List<T> select(Map<String, String> params);
	
	public List<T> getAll() { return null; }

}
