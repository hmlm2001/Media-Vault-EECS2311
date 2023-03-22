package backend;

import java.util.ArrayList;

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
	public ArrayList<Media> getMediaList(){
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
	
	public static void main(String[] args) {
		MediaCollection media = new MediaCollection(1);
		ArrayList<Media> med = media.getMediaList();
		System.out.println(med.get(1).getStatus());
	}
}
