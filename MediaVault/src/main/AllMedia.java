package main;

import java.util.HashMap;

public class AllMedia {

	/**
	 * AllMedia stores all available media in a Hashmap.
	 * It provides a search feature to navigate though the media. 
	 * */
	private HashMap<String, String> MediaMap; // the second string parameter will be replaced by "Media" the class has built.
	
	public AllMedia() {
		//read from file for 1st iteration
	}
	
	public String searchMedia(String name) { 
		// return parameter to be changed to "Media"
		
		String media = this.MediaMap.get(name);
		
		return media;
	} 
	
	private void updateMediaMap() {
		
	}
	
	
}
