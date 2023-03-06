package backend;

import java.util.ArrayList;

public class User {

	private String username;
	private ArrayList<Media> mediaCollection;
	/**
	 * Create a user with username
	 * @param username
	 */
	public User(String username) {
		this.username = username;
		this.mediaCollection = new ArrayList<Media>();
	}
	/**
	 * Returns the user's username
	 * @return
	 */
	public String getUsername() {
		
		return this.username;
	} 
	/**
	 * adds a media to a user's personal vault
	 * @param id is the id of the movie to added
	 * @return true if operation successful, false otherwise
	 */
	public boolean addMedia(int id) {
		
		return this.mediaCollection.add(new Movie(id));
	} 
	/**
	 * removes a media from the user's personal vault
	 * @param id is the id of the movie to be removed
	 * @return true if operation successful, false otherwise
	 */
	public boolean removeMedia(int id) {
		for (int i = 0; i<this.mediaCollection.size();i++) {
			if (this.mediaCollection.get(i).getId()==id) {
				this.mediaCollection.remove(i);
				return true;
			}
		}
		return false;
	} 
	/**
	 * gets the user's personal vault
	 * @return the arraylist containing movies from the user's personal vault
	 */
	public ArrayList<Media> getMediaList() {
		
		return this.mediaCollection; 
	} 
}
