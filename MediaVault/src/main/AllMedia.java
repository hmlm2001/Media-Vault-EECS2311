package main;

import java.util.Date;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AllMedia {

	/**
	 * AllMedia stores all available media in a Hashmap.
	 * It provides a search feature to navigate though the media. 
	 * */
	//should be private
	public HashMap<String, Media> MediaMap; // the second string parameter will be replaced by "Media" the class has built.
	
	public AllMedia() {
		//read from file for 1st iteration
		this.MediaMap = new HashMap<String, Media>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try (BufferedReader reader = new BufferedReader(new FileReader("src\\resources\\sampleMedia.csv"))) {
		    String line;
		    while ((line = reader.readLine()) != null) {
		    	
		        String[] values = line.split(",");
		        
		        Date date = dateFormat.parse(values[1]);
		        
		        this.MediaMap.put(values[0], new Media(values[0], date));
		        
		     
		    }
		} catch (IOException | ParseException e) {
		    System.out.println("could not read the file: " + e.getMessage() );
		}

		
	}
	
	public Media searchMedia(String name) { 
		// return parameter to be changed to "Media"
		
		Media media = this.MediaMap.get(name);
		
		return media;
	} 
	
	private void updateMediaMap() {
		
	}
	
	
	
}
