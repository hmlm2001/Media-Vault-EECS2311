package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import persistence.UserDB;

public class User {

	MediaCollection mediaList;
	public static HashMap<String, Integer> stub;
	private String username;
	private int id;
	private static final AtomicInteger count = new AtomicInteger(0); //for global id for stub users 
	/**
	 * Create a user with username and search for its id, if non-existent then create it
	 * @param username
	 */
	public User(String username) {
		this.username = username;
		if (!UseStub.getStubFlag()) { //checks if DB is being used
			this.id = UserDB.getId(username);
		} else {	//if stub is being used use the hardcoded values in makeStub
			if (stub==null) User.makeStub();
			if (!stub.containsKey(username)) stub.put(username, count.incrementAndGet());
			this.id = stub.get(username);
		}
		this.mediaList = new MediaCollection(this.id);
	}
	/**
	 * Help with testing, makes a stub DB
	 */
	private static void makeStub() {
		stub = new HashMap<String, Integer>();
		stub.put("user1", count.incrementAndGet());
		stub.put("user2", count.incrementAndGet());
		stub.put("user3", count.incrementAndGet());
	}
	/**
	 * @return the user's username
	 */
	public String getUsername() {
		
		return this.username;
	} 
	/**
	 * @return the user's id
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * adds a media to a user's personal vault
	 * @param id is the id of the movie to added
	 * @return true if operation successful, false otherwise
	 */
	public boolean addMedia(int id) {
		return this.mediaList.addMedia(new Movie(id));
	} 
	/**
	 * removes a media from the user's personal vault
	 * @param id is the id of the movie to be removed
	 * @return true if operation successful, false otherwise
	 */
	public boolean removeMedia(int id) {
		return this.mediaList.removeMedia(id);
	} 
	/**
	 * gets the user's personal vault
	 * @return the arraylist containing movies from the user's personal vault
	 */
	public ArrayList<Media> getMediaList() {
		return this.mediaList.getMediaList(); 
	} 
}
