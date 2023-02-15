package backend;

import java.util.ArrayList;

public class User {

	private String username;
	private MediaCollection mediaCollection; 
	
	public String getUsername() {
		
		return this.username;
	} 
	
	public boolean addMedia(Media media) {
		
		return this.mediaCollection.addMedia(media);
	} 

	public boolean removeMedia(Media media) {
		
		return this.mediaCollection.removeMedia(media);
	} 

	public ArrayList<Media> getMediaList() {
		
		return this.mediaCollection.getMediaList(); 
	} 
}
