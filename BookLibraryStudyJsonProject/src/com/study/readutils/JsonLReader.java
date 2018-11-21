package com.study.readutils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;
import com.study.model.Library;

public class JsonLReader {
	
	public List<Library> readJsonStream(InputStream fis) throws IOException {
		JsonReader jreader = new JsonReader(new InputStreamReader(fis, "UTF-8"));
		try {
			return readLibrariesArray(jreader);
		} finally {
			jreader.close();
		}
	}
	
	public List<Library> readLibrariesArray(JsonReader jreader) throws IOException {
		List<Library> libraries = new ArrayList<Library>();
		
		jreader.beginArray();
		while(jreader.hasNext()) {
			libraries.add(readLibrary(jreader));
		}
		jreader.endArray();
		return libraries;
	}
	
	public Library readLibrary(JsonReader jreader) throws IOException {
		long id = -1;
		String libname = null;
		String city = null;
		
		jreader.beginObject();
		while (jreader.hasNext()) {
			String name = jreader.nextName();
			
			if (name.equals("id")) {
				id = jreader.nextLong();
			} else if (name.equals("name")) {
				libname = jreader.nextString();
			} else if (name.equals("city")) {
				city = jreader.nextString();
			}  else {
				jreader.skipValue();
			}
		}
		jreader.endObject();
		
		Library library = new Library(id, libname, city);
		return library;	
	}

}
