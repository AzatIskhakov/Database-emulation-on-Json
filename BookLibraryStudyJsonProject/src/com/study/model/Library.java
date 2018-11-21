package com.study.model;

import java.util.Set;
import java.util.TreeSet;

public class Library implements Comparable<Library> {
	
	private Set<Book> bookSet;
	private long id;
    private String name;
    private String city;
    public static long idCounter = 0;
    
    public Library(String name, String city) {
        this.bookSet = new TreeSet<>();
        this.id = idCounter++;
        this.name = name;
        this.city = city;
    }

    public Library(long id, String name, String city) {
        this.bookSet = new TreeSet<>();
        this.id = id;
        this.name = name;
        this.city = city;
    }

	public Set<Book> getBookSet() {
		return bookSet;
	}

	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
    
    public void addBook(Book book) {
    	bookSet.add(book);
    }
    
    public boolean isBook(Book book) {
    	return bookSet.stream().filter(b -> b.equals(book)).findFirst().orElse(null) != null ? true : false;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        if (id != library.id) return false;
        if (bookSet != null ? !bookSet.equals(library.bookSet) : library.bookSet != null) return false;
        if (name != null ? !name.equals(library.name) : library.name != null) return false;
        return city != null ? city.equals(library.city) : library.city == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		return "Library [bookSet=" + bookSet + ", id=" + id + ", name=" + name + ", city=" + city + "]";
	}
    
	@Override
    public int compareTo(Library o) {
        Long one = o.getId();
        Long two = this.getId();
        return  two.compareTo(one);
    } 

}
