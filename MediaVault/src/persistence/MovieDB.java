package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDB {
	private ArrayList<Movie> movieList;
	
	/**
	 * Constructor for the class initializes the ArrayList then updates it.
	 */
	public MovieDB() {
		movieList = new ArrayList<>();
		this.updateMovieList();
	}
	
	/**
	 * Updates the movie list by adding movies using the movie ids in the database.
	 * Only the id is stored in Java. Other details are retrieved only when necessary.
	 */
	private void updateMovieList() {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT id FROM allmovies;");
		try {
			while (result.next()) {
				Movie movie = new Movie(result.getInt("id"));
				this.movieList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public boolean contains(Movie movie) {
		return movieList.contains(movie);
	}
	
	public Movie get(int index) {
		return movieList.get(index);
	}
	
	public int size() {
		return movieList.size();
	}
}
