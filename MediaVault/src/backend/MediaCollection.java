package backend;

import java.util.ArrayList;
import java.util.HashMap;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import persistence.MediaCollectionDB;

public class MediaCollection {
	
	//make an empty ArrayList to store the user selected media
	private ArrayList<Media> mediaList;
	private int id;
	
	/**
	 * Create a mediacollection object with the input of userid, if using stub, the nuse hardcoded values, if not, the nuse MediaCollectionDB
	 * @param userid is the user's id
	 */
	public MediaCollection(int userid) {
		if (!UseStub.getStubFlag()) {	//if not using stub, use DB
			this.id = MediaCollectionDB.getMediaCollectionId(userid); //get the collection id associated with the user
			mediaList = MediaCollectionDB.getMediaCollection(this.id); //get the ArrayList<Media> associated with the collection id
		} else {	//if using stub, use hardcoded values where users with id 1, 2 and 3 have collections with existing movies
			mediaList = new ArrayList<Media>();
			if (userid == 1) {
				this.id=1;
				mediaList.add(new Movie(631842).setStatus("Compeleted"));
			} else if (userid == 2) {
				this.id=2;
				mediaList.add(new Movie(505642).setStatus("Yet to Watch"));
				mediaList.add(new Movie(315162).setStatus("In Prograss"));
			} else if (userid == 3) {
				this.id=3;
				mediaList.add(new Movie(646389).setStatus("Yet to Watch"));
				mediaList.add(new Movie(772515).setStatus("Compeleted"));
			}
		}
	}
	/**
	 * @return the collection
	 */
	public ArrayList<Media> getMediaList() {
		return mediaList;
	}
	
	/**
	 * Adds a media to a collection
	 * @param is the input media
	 * @return true if add successful, false otherwise (such as in the case where it is already in the list)
	 */
	public boolean addMedia(Media m) {
		//first checks if the user selected media is in the list already
		for (int i = 0; i<mediaList.size(); i++) {
			if(m.getId()==mediaList.get(i).getId()) return false;
		}
		//if not already in the list it then adds the media to the ArrayList
		mediaList.add(m);
		if (!UseStub.getStubFlag()) MediaCollectionDB.addMediaCollection(this.id, m.getId());
		return true;
	}
	
	/**
	 * remove a media form the list
	 * @param id is the id of the to-be removed id
	 * @return true if successful, false otherwise
	 */
	public boolean removeMedia(int id) {
		
		for (int i = 0; i<this.mediaList.size();i++) {
			if (this.mediaList.get(i).getId()==id) {
				this.mediaList.remove(i);
				if (!UseStub.getStubFlag()) return MediaCollectionDB.removeMediaCollection(this.id, id);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Set the status of a movie in a user's vault
	 * @param id of the movie
	 * @param Status to be set
	 * @return true if successful, false otherwise
	 */
	public boolean setStatus(int id, String Status) {
		for (int i = 0; i<this.mediaList.size();i++) {
			if (this.mediaList.get(i).getId()==id) {
				String oldStatus = this.mediaList.get(i).getStatus();
				this.mediaList.get(i).setStatus(Status);
				if (!UseStub.getStubFlag()) 
					return MediaCollectionDB.setStatus(this.id, id,oldStatus, Status  );				
				return true;
			}			
		}
		return false;
	}
	
	/**
	 * returns the size of the mediaList
	 * @return
	 */
	public int size() {
		return mediaList.size();
	}
	
	/** 
	 * gets the id of the collection
	 * @return the id of the collection
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * gets the total watch time for completed media
	 * @return
	 */
	public String getTotalWatchtime() {
		int watchtimeInt = 0;
		for (Media media : mediaList) {
			if (media.getStatus().equals("Completed")) {
				watchtimeInt += media.getRuntime();
			}
		}
		String watchtimeStr = (watchtimeInt / 60) + "h " + (watchtimeInt % 60) + "m";
		return watchtimeStr;
	}
	
	// TODO: Implement
	public PieDataset createGenreDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (Media media : mediaList) {
			String key = media.getGenre();
			int count = 0;
			if (map.containsKey(key)) {
				count = map.get(key);
				map.put(key, count);
			} else {
				map.put(key, count);
			}
		}
		return dataset;
	}
	
	// TODO: Implement
	public CategoryDataset createStatusDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		return dataset;
	}
}
