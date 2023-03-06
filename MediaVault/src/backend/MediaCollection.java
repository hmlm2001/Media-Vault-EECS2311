package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistence.JDBC_Connection;
import persistence.MediaCollectionDB;

public class MediaCollection {
	
	//make an empty ArrayList to store the user selected media
	private ArrayList<Media> mediaList;
	private int id;
	
	public MediaCollection(int userid) {
		if (!UseStub.getStubFlag()) {
			this.id = MediaCollectionDB.getMediaCollectionId(userid);
			mediaList = MediaCollectionDB.getMediaCollection(this.id);
		} else {
			mediaList = new ArrayList<Media>();
			if (userid == 1) {
				this.id=1;
				mediaList.add(new Movie(631842));
			} else if (userid == 2) {
				this.id=2;
				mediaList.add(new Movie(505642));
				mediaList.add(new Movie(315162));
			} else if (userid == 3) {
				this.id=3;
				mediaList.add(new Movie(646389));
				mediaList.add(new Movie(772515));
			}
		}
	}
	
	public ArrayList<Media> getMediaList(){
		return mediaList;
	}
	
	// this method adds the media into the list
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
	
	// this method removes the user selected media
	public boolean removeMedia(int id) {
		for (int i = 0; i<this.mediaList.size();i++) {
			if (this.mediaList.get(i).getId()==id) {
				this.mediaList.remove(i);
				if (!UseStub.getStubFlag()) MediaCollectionDB.removeMediaCollection(this.id, id);
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
}
