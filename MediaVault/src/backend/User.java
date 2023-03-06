package backend;

import java.util.ArrayList;

public class User {

	private String username;
	private ArrayList<Media> mediaCollection;
	
	public User(String username) {
		this.username = username;
		this.mediaCollection = new ArrayList<Media>();
	}
	public String getUsername() {
		
		return this.username;
	} 
	
	public boolean addMedia(int id) {
		
		return this.mediaCollection.add(new Movie(id));
	} 

	public boolean removeMedia(int id) {
		
		return this.mediaCollection.remove(new Movie(id));
	} 

	public ArrayList<Media> getMediaList() {
		
		return this.mediaCollection; 
	} 
}
