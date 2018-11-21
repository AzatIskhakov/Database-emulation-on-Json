package com.study.model;

public class Book implements Comparable<Book>{
	
	private long id;
    private String name;
    private Reader readerReserved;
    private int edition = 0;
    private int daysForLeasing = 0;
    public static long idCounter = 0;
    
    public Book(String name, int price, int daysForLeasing) {
        this.id = idCounter++;
        this.name = name;
        this.edition = edition;
        this.daysForLeasing = daysForLeasing;
    }
    
    public Book(long id, String name, int edition, int daysForLeasing) {
        this.id = id;
        this.name = name;
        this.edition = edition;
        this.daysForLeasing = daysForLeasing;
    }    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Reader getReaderReserved() {
		return readerReserved;
	}

	public void setReaderReserved(Reader readerReserved) {
		this.readerReserved = readerReserved;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getDaysForLeasing() {
		return daysForLeasing;
	}

	public void setDaysForLeasing(int daysForLeasing) {
		this.daysForLeasing = daysForLeasing;
	}
	
	public boolean isReserved() {
		return readerReserved == null ? false : true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + daysForLeasing;
		result = prime * result + edition;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((readerReserved == null) ? 0 : readerReserved.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (daysForLeasing != other.daysForLeasing)
			return false;
		if (edition != other.edition)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (readerReserved == null) {
			if (other.readerReserved != null)
				return false;
		} else if (!readerReserved.equals(other.readerReserved))
			return false;
		return true;
	}
	
	@Override
    public int compareTo(Book o) {
        Long one = o.getId();
        Long two = this.getId();
        return  two.compareTo(one);
    }

}
