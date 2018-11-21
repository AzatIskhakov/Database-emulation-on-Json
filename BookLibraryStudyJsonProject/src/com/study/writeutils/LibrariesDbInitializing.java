package com.study.writeutils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.study.model.Library;

public class LibrariesDbInitializing {
	
	public static void initDB() {
		JsonLWriter jlwr = new JsonLWriter();
		List<Library> listOfLibraries = new ArrayList<>();
		Library l1 = new Library(0, "Central Library", "Washington");
		Library l2 = new Library(1, "Lenin's Library", "Moscow");
		Library l3 = new Library(2, "Lobachevsky Library", "Nizhny Novgorod");
		
		listOfLibraries.add(l1);
		listOfLibraries.add(l2);
		listOfLibraries.add(l3);
		
		try {
			FileOutputStream fos = new FileOutputStream("libraries.json");
			jlwr.writeJsonStream(fos, listOfLibraries);
		} catch(FileNotFoundException fnfe) {
			 fnfe.printStackTrace(); 
	      } catch(IOException e) { 
	         e.printStackTrace();
	      } catch (IllegalStateException ise) {
	    	  ise.printStackTrace();
	      }
	}

}
