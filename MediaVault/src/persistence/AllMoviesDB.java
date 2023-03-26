package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import backend.*;
import java.util.ArrayList;

public class AllMoviesDB {
	private ArrayList<Movie> movieList;
	
	/**
	 * Constructor for the class initializes the ArrayList then updates it.
	 */
	public AllMoviesDB() {
		movieList = new ArrayList<>();
		this.updateMovieList();
	}
	
	/**
	 * Updates the movie list by adding movies using the movie ids in the database.
	 * Only the id is stored in Java. Other details are retrieved only when necessary.
	 */
	private void updateMovieList() {
		ResultSet result;
		ActiveConnection activeCon = JDBC_Connection.getResult("SELECT id FROM allmovies;");
		result = activeCon.result;
		try {
			while (result.next()) {
				Movie movie = new Movie(result.getInt("id"));
				this.movieList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		activeCon.closeConnection();
	}
		
	/**
	 * Checks if a movie is in the movie list
	 * @param movie to be checked
	 * @return true if the movie is in movieList, false otherwise
	 */
	public boolean contains(Movie movie) {
		return movieList.contains(movie);
	}
	
	/**
	 * Gets a movie from the movie list given an index
	 * @param index of the element to be returned
	 * @return the movie at the given index
	 */
	public Movie get(int index) {
		return movieList.get(index);
	}
	
	/**
	 * @return the size of the movie lists
	 */
	public int size() {
		return movieList.size();
	}
}
