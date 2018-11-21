package com.study.model;

public class Reader implements Comparable<Reader> {
	
	private long id;
	private String login;
	public static long idCounter = 0;
	
	public Reader(String login) {
        this.id = idCounter++;
        this.login = login;
    }
	
	public Reader(long id, String login) {
        this.id = id;
        this.login = login;
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Reader other = (Reader) obj;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reader [id=" + id + ", login=" + login + "]";
	}
	
	@Override
    public int compareTo(Reader o) {
        Long one = o.getId();
        Long two = this.getId();
        return  two.compareTo(one);
    }
	

}
