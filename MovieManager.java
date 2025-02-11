package com.aurionpro.model;

import java.io.*;
import java.util.*;

public class MovieManager {
	private List<Movie> movies;
	private static final String filePath = "movies.dat";

	public MovieManager() {
		movies = new ArrayList<>();
		loadMovies();
	}

	public void addMovie(Movie movie) {
		if (movies.size() < 5) {
			movies.add(movie);
			saveMovies();
		}
	}

	public void clearMovies() {
		movies.clear();
		saveMovies();
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public int getMovieId() {
		return movies.size() + 1;
	}

	public void loadMovies() {
		File file = new File(filePath);
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				movies = (List<Movie>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				// Ignored
			}
		}
	}

	public void saveMovies() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
			oos.writeObject(movies);
		} catch (IOException e) {
			// Ignored
		}
	}

	public void deleteAllMovies() {
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}
		movies.clear();
	}
}
