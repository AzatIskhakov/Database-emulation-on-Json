package com.study.writeutils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.google.gson.stream.JsonWriter;
import com.study.model.Library;

public class JsonLWriter implements TypeSelector<Library> {
	
	
	public void writeJsonStream(OutputStream out, List<Library> libraries) throws IOException {
	     JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
	     writer.setIndent("    ");
	     writeLibrariesArray(writer, libraries);
	     writer.close();
	   }
	
	public void writeLibrariesArray(JsonWriter writer, List<Library> libraries) throws IOException {
	     writer.beginArray();
	     for (Library library : libraries) {
	    	 writeLibrary(writer, library);
	     }
	     writer.endArray();
	   }
	
	public void writeLibrary(JsonWriter writer, Library library) throws IOException {
	     writer.beginObject();
	     writer.name("id").value(library.getId());
	     writer.name("name").value(library.getName());
	     writer.name("city").value(library.getCity());
	     writer.endObject();
	   }

}
