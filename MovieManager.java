package com.aurionpro.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies;
    private static final String filePath = "data.bin";

    public MovieManager() {
        movies = new ArrayList<>();
        loadMovies();
    }

    // Add a movie
    public void addMovie(Movie movie) {
        if (movies.size() >= 5) {
            throw new RuntimeException("CapacityFullException: Cannot add more than 5 movies.");
        }
        movies.add(movie);
        saveMovies();
    }

    // Clear all movies
    public void clearMovies() {
        movies.clear();
        saveMovies();
    }

    // Get all movies
    public List<Movie> getMovies() {
        return movies;
    }

    // Get the next available movie ID
    public int getMovieId() {
        return movies.size() + 1;
    }

    // Load movies from file
    public void loadMovies() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            movies = (List<Movie>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No saved movies found. Starting with an empty list.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading movies: " + e.getMessage());
        }
    }

    // Save movies to file
    public void saveMovies() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(movies);
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
        }
    }

    // Delete all movies permanently
    public void deleteAllMovies() {
        clearMovies();
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }
}
