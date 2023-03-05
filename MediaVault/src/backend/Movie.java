package backend;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistence.MovieDB;

public class Movie extends Media {
	private String title;
	private Date releaseDate;
	private String overview;
	private String posterPath;
	private String genre;
	private int runtime;
	
	/**
	 * Takes the id and sets up an object of movie with the help of the databaase
	 * @param id is the id of the movie
	 */
	public Movie(int id) {
		super(id);
		try {
			ResultSet result=MovieDB.getMovie(this.getId());
			while (result.next()) {
				this.title=result.getString(2);
				this.releaseDate=result.getDate(3);
				this.overview=result.getString(4);
				this.posterPath=result.getString(5);
				this.genre=result.getString(6);
				this.runtime=result.getInt(7);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return the title of the movie
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * @return the release date of the movie
	 */
	public Date getReleaseDate() {
		return this.releaseDate;
	}
	/**
	 * @return the overview of the movie
	 */
	public String getOverview() {
		return this.overview;
	}
	/**
	 * @return the poster path of the movie (in the form of a url)
	 */
	public String getPosterPath() {
		return this.posterPath;
	}
	/**
	 * @return the genre of the movie
	 */
	public String getGenre() {
		return this.genre;
	}
	/**
	 * @return the runtime of the movie in minutes
	 */
	public int getRuntime() {
		return this.runtime;
	}
}
