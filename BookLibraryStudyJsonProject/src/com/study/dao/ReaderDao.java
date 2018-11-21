package com.study.dao;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.study.model.Reader;

public class ReaderDao extends AbstractDao<Reader> {
	
	private String fileSource = "readers.json";
	
	@Override
	public void update(long id, Reader readerToUpdate) {
		Set<Reader> readers = new TreeSet<>(getAll());
		readers.stream().filter(reader -> reader.getId()==id).forEach(reader1 ->
				reader1.setLogin(readerToUpdate.getLogin()));
		
	}

	@Override
	public Set<Reader> select(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
