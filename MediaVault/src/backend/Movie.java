package backend;

import java.sql.ResultSet;
import java.sql.SQLException;

import persistence.ActiveConnection;
import persistence.MovieDB;

public class Movie extends Media {
	private String releaseDate;
	private String overview;
	private String posterPath;
	private String genre;
	private int runtime;
	
	/**
	 * Takes the id and sets up an object of movie with the help of the database
	 * @param id is the id of the movie
	 */
	public Movie(int id) {
		super(id);
		ResultSet result = null;
		ActiveConnection activeCon = null;
		if (!UseStub.getStubFlag()) {	//checks if the DB is being used
			try {
				activeCon = MovieDB.getMovie(this.getId());
				result= activeCon.result;	//get the values associated with the id
				while (result.next()) { //assign the values
					this.title=result.getString(2);
					this.releaseDate=result.getString(3);
					this.overview=result.getString(4);
					this.posterPath=result.getString(5);
					this.genre=result.getString(6);
					this.runtime=result.getInt(7);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			activeCon.closeConnection();
		} else { //if using stub, use one of the following hardcoded values
			if (id==631842){
				this.title="Knock at the Cabin";
				this.releaseDate="2023-02-01";
				this.overview="While vacationing at a remote cabin, a young girl and her two fathers are taken hostage by four armed strangers who demand that the family make an unthinkable choice to avert the apocalypse. With limited access to the outside world, the family must decide what they believe before all is lost.";
				this.posterPath="http://image.tmdb.org/t/p/w500/dm06L9pxDOL9jNSK4Cb6y139rrG.jpg";
				this.genre="Horror";
				this.runtime=100;
			} else if (id==505642){
				this.title="Black Panther: Wakanda Forever";
				this.releaseDate="2022-11-09";
				this.overview="Queen Ramonda, Shuri, M’Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King T’Challa’s death.  As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia and Everett Ross and forge a new path for the kingdom of Wakanda.";
				this.posterPath="http://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg";
				this.genre="Action";
				this.runtime=162;
			} else if (id==315162){
				this.title="Puss in Boots: The Last Wish";
				this.releaseDate="2022-12-07";
				this.overview="Puss in Boots discovers that his passion for adventure has taken its toll: He has burned through eight of his nine lives, leaving him with only one life left. Puss sets out on an epic journey to find the mythical Last Wish and restore his nine lives.";
				this.posterPath="http://image.tmdb.org/t/p/w500/kuf6dutpsT0vSVehic3EZIqkOBt.jpg";
				this.genre="Animation";
				this.runtime=103;
			} else if (id==646389){
				this.title="Plane";
				this.releaseDate="2023-01-12";
				this.overview="After a heroic job of successfully landing his storm-damaged aircraft in a war zone, a fearless pilot finds himself between the agendas of multiple militias planning to take the plane and its passengers hostage.";
				this.posterPath="http://image.tmdb.org/t/p/w500/qi9r5xBgcc9KTxlOLjssEbDgO0J.jpg";
				this.genre="Action";
				this.runtime=107;
			} else if (id==772515){
				this.title="Huesera: The Bone Woman'";
				this.releaseDate="2023-02-10";
				this.overview="Valeria''s joy at becoming a first-time mother is quickly taken away when she''s cursed by a sinister entity. As danger closes in, she''s forced deeper into a chilling world of dark magic that threatens to consume her.";
				this.posterPath="http://image.tmdb.org/t/p/w500/1mZcxuL4GLUvPdEXC4iZPjG2EO3.jpg";
				this.genre="Drama";
				this.runtime=93;
			} else {	//default to puss in boots
				this.title="Puss in Boots: The Last Wish";
				this.releaseDate="2022-12-07";
				this.overview="Puss in Boots discovers that his passion for adventure has taken its toll: He has burned through eight of his nine lives, leaving him with only one life left. Puss sets out on an epic journey to find the mythical Last Wish and restore his nine lives.";
				this.posterPath="http://image.tmdb.org/t/p/w500/kuf6dutpsT0vSVehic3EZIqkOBt.jpg";
				this.genre="Animation";
				this.runtime=103;
			}
		}
	}
	/**
	 * @return the release date of the movie
	 */
	public String getReleaseDate() {
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
	
	/**
	 * @return the runtime of the movie as a string
	 */
	public String getRuntimeAsString() {
		int runtimeInt = this.getRuntime();
		int hours = runtimeInt / 60;
		int minutes = runtimeInt % 60;
		return hours + "h " + minutes + "m";
	}
}
