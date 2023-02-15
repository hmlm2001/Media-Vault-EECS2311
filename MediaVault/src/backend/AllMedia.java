package backend;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AllMedia {

	/**
	 * AllMedia stores all available media in a HashMap.
	 * It provides a search feature to navigate though the media. 
	 * */
	
	private HashMap<String, Media> MediaMap; // the second string parameter will be replaced by "Media" the class has built.
	
	/**
	 * creates a new HashMap and updates the values; 
	 */
	
	public AllMedia() {
		//read from file for 1st iteration
		this.MediaMap = new HashMap<String, Media>();
		
		this.updateMediaMap();
		
	}
	
	/**
	 * 
	 * @param name the name of media to search for. 
	 * @return the associated Media object.
	 * @throws Exception if the Media is not available
	 */
	public Media searchMedia(String name) throws Exception { 
		
		name = name.toLowerCase(Locale.ROOT);
		
		if (this.MediaMap.containsKey(name)){
			Media media = this.MediaMap.get(name); //could return null if the key is mapped but the media object has not been created 
			return media;
		}
		
		// could give option to add the media manually from here or from the method calling searchMedia
		// updateMediaMap(name);
		throw new Exception(name + " is not currently available ");
		
		
	} 
	
	/**
	 * This method reads the sample data and updated MediaMap accordingly.
	 */
	private void updateMediaMap() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try (BufferedReader reader = new BufferedReader(new FileReader("src\\resources\\sampleMedia.csv"))) {
		    String line;
		    while ((line = reader.readLine()) != null) {
		    	
		        String[] values = line.split(",");
		        values[0] = values[0].toLowerCase(Locale.ROOT);
		        
		        Date date = dateFormat.parse(values[1]);
		        
		        this.MediaMap.put(values[0], new Media(values[0], date));
		        
		     
		    }
		} catch (IOException | ParseException e) {
		    System.out.println("could not read the file: " + e.getMessage() );
		}
	}
	
	
	
}
