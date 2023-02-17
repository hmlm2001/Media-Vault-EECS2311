package backend;

import java.util.Date;

public class Media {
	private String name;
	private Date releaseDate;
	

	public String getName() {
		return name;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public Media(String name, Date releaseDate) {
		this.name = name;
		this.releaseDate = releaseDate;
	}
	
}
