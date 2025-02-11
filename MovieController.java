package com.aurionpro.test;

import com.aurionpro.model.*;
import java.util.Scanner;

public class MovieController {
	private MovieManager manager;

	public MovieController() {
		manager = new MovieManager();
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			displayMenu();
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
				case 1:
					displayMovies();
					break;
				case 2:
					setMovieDetails(scanner);
					break;
				case 3:
					manager.clearMovies();
					System.out.println("All movies have been cleared.");
					break;
				case 4:
					System.out.println("Exiting application. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 4);

		scanner.close();
	}

	private void displayMenu() {
		System.out.println("\nSimpleMoviesApp Menu:");
		System.out.println("1. Display Movies");
		System.out.println("2. Add Movie");
		System.out.println("3. Clear All Movies");
		System.out.println("4. Exit");
	}

	private void displayMovies() {
		if (manager.getMovies().isEmpty()) {
			System.out.println("No movies to display.");
		} else {
			System.out.println("Movies:");
			for (Movie movie : manager.getMovies()) {
				System.out.println(movie);
			}
		}
	}

	private void setMovieDetails(Scanner scanner) {
		System.out.print("Enter movie name: ");
		String name = scanner.nextLine();

		System.out.print("Enter movie year: ");
		int year = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		System.out.print("Enter movie genre: ");
		String genre = scanner.nextLine();

		Movie movie = new Movie(manager.getMovieId(), name, year, genre);
		manager.addMovie(movie);
		System.out.println("Movie added successfully.");
	}

	public static void main(String[] args) {
		new MovieController().start();
	}
}
