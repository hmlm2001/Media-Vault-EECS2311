package backend;

import java.util.Date;

public class Media {
	private String title;
	private Date releaseDate;
	

	public String getName() {
		return this.title;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}
	
	public Media(String name, Date releaseDate) {
		this.title = name;
		this.releaseDate = releaseDate;
	}
	
}
