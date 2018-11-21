package com.study.readutils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;
import com.study.model.Reader;

public class JsonRReader {
	
	public List<Reader> readJsonStream(InputStream fis) throws IOException {
		JsonReader jreader = new JsonReader(new InputStreamReader(fis, "UTF-8"));
		try {
			return readReadersArray(jreader);
		} finally {
			jreader.close();
		}
	}
	
	public List<Reader> readReadersArray(JsonReader jreader) throws IOException {
		List<Reader> messages = new ArrayList<Reader>();
		
		jreader.beginArray();
		while(jreader.hasNext()) {
			messages.add(readMessage(jreader));
		}
		jreader.endArray();
		return messages;
	}
	
	public Reader readMessage(JsonReader jreader) throws IOException {
		long id = -1;
		String login = null;
		
		jreader.beginObject();
		while (jreader.hasNext()) {
			String name = jreader.nextName();
			if (name.equals("id")) {
				id = jreader.nextLong();
			} else if (name.equals("login")) {
				login = jreader.nextString();
			} else {
				jreader.skipValue();
			}
		}
		jreader.endObject();
		
		Reader rdr = new Reader(id, login);
		return rdr;	
	}

}
