package backend;

import java.util.Date;

public class Movie extends Media{
	private int id;
	private String poster;
	private String genre;
	
	public Movie(String name, Date releaseDate) {
		super(name, releaseDate);
	}
	
	public static Movie newMovie(String name, Date releaseDate, int id, String poster, String genre) {
		Movie movie = new Movie(name, releaseDate);
		movie.id = id;
		movie.genre = genre;
		movie.poster = poster;
		return movie;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getPoster() {
		return this.poster;
	}
	
	public String getGenre() {
		return this.genre;
	}
	

}
