package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDuplicate {
	private int id;
	private String title;
	private String releaseDate;
	private String overview;
	private String posterPath;
	private String genre;
	private int runtime;
	
	/**
	 * Constructor for this class only saves the id based on the input argument.
	 * Getters are used to retrieve other info when needed by sending queries to the DB.
	 * @param id is the id of the movie in the database
	 */
	public MovieDuplicate(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT title FROM allmovies WHERE id='"+id+"';");
		try {
			while (result.next()) {
				this.title = result.getString("title");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.title;
	}
	
	public String getReleaseDate() {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT releaseDate FROM allmovies WHERE id='"+id+"';");
		try {
			while (result.next()) {
				this.releaseDate = result.getString("releaseDate");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.releaseDate;
	}
	
	public String getOverview() {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT overview FROM allmovies WHERE id='"+id+"';");
		try {
			while (result.next()) {
				this.overview = result.getString("overview");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.overview;
	}
	
	public String getPosterPath() {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT posterPath FROM allmovies WHERE id='"+id+"';");
		try {
			while (result.next()) {
				this.posterPath = result.getString("posterPath");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.posterPath;
	}
	
	public String getGenre() {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT genre FROM allmovies WHERE id='"+id+"';");
		try {
			while (result.next()) {
				this.genre = result.getString("genre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.genre;
	}
	
	public int getRuntimeInMinutes() {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT runtime FROM allmovies WHERE id='"+id+"';");
		try {
			while (result.next()) {
				this.runtime = result.getInt("runtime");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.runtime;
	}	
	
	public String getRuntimeAsString() {
		int runtimeInt = this.getRuntimeInMinutes();
		int hours = runtimeInt / 60;
		int minutes = runtimeInt % 60;
		return hours + "h " + minutes + "m";
	}
}
