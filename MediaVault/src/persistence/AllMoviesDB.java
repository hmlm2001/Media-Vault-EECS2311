package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllMoviesDB {
	private ArrayList<MovieDuplicate> movieList;
	
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
		result = JDBC_Connection.getResult("SELECT id FROM allmovies;");
		try {
			while (result.next()) {
				MovieDuplicate movieDuplicate = new MovieDuplicate(result.getInt("id"));
				this.movieList.add(movieDuplicate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public boolean contains(MovieDuplicate movieDuplicate) {
		return movieList.contains(movieDuplicate);
	}
	
	public MovieDuplicate get(int index) {
		return movieList.get(index);
	}
	
	public int size() {
		return movieList.size();
	}
}
