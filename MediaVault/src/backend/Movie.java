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
	public String getTitle() {
		return this.title;
	}
	public Date getReleaseDate() {
		return this.releaseDate;
	}
	public String getOverview() {
		return this.overview;
	}
	public String getPosterPath() {
		return this.posterPath;
	}
	public String getGenre() {
		return this.genre;
	}
	public int getRuntime() {
		return this.runtime;
	}
}
