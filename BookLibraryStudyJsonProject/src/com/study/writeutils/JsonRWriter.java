package com.study.writeutils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.google.gson.stream.JsonWriter;
import com.study.model.Reader;

public class JsonRWriter implements TypeSelector<Reader> {
	
	public void writeJsonStream(OutputStream out, List<Reader> readers) throws IOException {
	     JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
	     writer.setIndent("    ");
	     writeReaderesArray(writer, readers);
	     writer.close();
	   }
	
	public void writeReaderesArray(JsonWriter writer, List<Reader> readers) throws IOException {
	     writer.beginArray();
	     for (Reader reader : readers) {
	       writeReader(writer, reader);
	     }
	     writer.endArray();
	   }
	
	public void writeReader(JsonWriter writer, Reader reader) throws IOException {
	     writer.beginObject();
	     writer.name("id").value(reader.getId());
	     writer.name("login").value(reader.getLogin());
	     writer.endObject();
	   }

}
