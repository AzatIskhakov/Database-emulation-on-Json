package com.study.writeutils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.study.model.Reader;

public class ReadersDbInitializing {
	
	public static void initDB() {
		JsonRWriter jrwr = new JsonRWriter();
		List<Reader> listOfReaders = new ArrayList<>();
		Reader r1 = new Reader(0L, "John");
		Reader r2 = new Reader(1L, "Andrew");
		Reader r3 = new Reader(2L, "Azat");
		Reader r4 = new Reader(3L, "Melissa");
		Reader r5 = new Reader(4L, "Dasha");
		
		listOfReaders.add(r1);
		listOfReaders.add(r2);
		listOfReaders.add(r3);
		listOfReaders.add(r4);
		listOfReaders.add(r5);
		
		try {
			FileOutputStream fos = new FileOutputStream("readers.json");
			jrwr.writeJsonStream(fos, listOfReaders);
		} catch(FileNotFoundException fnfe) {
			 fnfe.printStackTrace(); 
	      } catch(IOException e) { 
	         e.printStackTrace();
	      } catch (IllegalStateException ise) {
	    	  ise.printStackTrace();
	      }
	}

}
