package main;

import java.util.ArrayList;

public class User {

	private String username;
	private String mediaCollection; // to be changed to type mediaCollection 
	
	public String getUsername() {
		
		return this.username;
	} 
	
	public boolean addMedia(String media) { // to be changed to type media 
		
		return false;
	} 

	public boolean removeMedia(String media) {// to be changed to type media 
		
		return false;
	} 

	public ArrayList<String> getmediaList() {// to be changed to type mediaCollection 
		
		return new ArrayList<>(); //mediacollection.media;
	} 
}
