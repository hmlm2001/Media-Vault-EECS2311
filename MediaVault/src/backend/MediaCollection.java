package backend;

import java.util.ArrayList;

public class MediaCollection {
	
	//make an empty ArrayList to store the user selected media
	ArrayList<Media> mediaList;
	
	public MediaCollection() {
		mediaList = new ArrayList<Media>();
	}
	
	// this method adds the media into the list
	public Boolean addMedia(Media m) {
		//first checks if the user selected media is in the list already
		if (mediaList.contains(m)) {
			return false;
		}
		//if not already in the list it then adds the media to the ArrayList
		else {
			mediaList.add(m);
			return true;
		}
	}
	// this method removes the user selected media
	public Boolean removeMedia(Media m) {
		//first checks if the media is actually in the ArrayList or not 
		if (!mediaList.contains(m)) {
			return false;
		}
		//if it is, then removes the selected user media from the ArrayList
		else {
		mediaList.remove(m);
		return true;
		}
		
	}
	public ArrayList<Media>getMediaList(){
		return mediaList;
	}
}
