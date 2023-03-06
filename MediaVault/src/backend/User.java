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
		for (int i = 0; i<this.mediaCollection.size();i++) {
			if (this.mediaCollection.get(i).getId()==id) {
				this.mediaCollection.remove(i);
				return true;
			}
		}
		return false;
	} 

	public ArrayList<Media> getMediaList() {
		
		return this.mediaCollection; 
	} 
}
