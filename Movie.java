package com.aurionpro.model;

public class Movie {
	private int id;
	private String name;
	private int year;
	private String genre;

	// Default Constructor
	public Movie() {

	}

	// Parameterized Constructor
	public Movie(int id, String name, int year, String genre) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.genre = genre;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public String getGenre() {
		return genre;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	// toString method
	public String toString() {
		return "Movie id: " + id + ", Movie name: " + name + ", Year: " + year + ", Genre: " + genre;
	}

}
