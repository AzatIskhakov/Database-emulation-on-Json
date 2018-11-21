package com.study.writeutils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.study.model.Book;
import com.study.model.Library;

public interface TypeSelector<T> {
	
	abstract void  writeJsonStream(OutputStream out, List<T> dataSet) throws IOException;


}
