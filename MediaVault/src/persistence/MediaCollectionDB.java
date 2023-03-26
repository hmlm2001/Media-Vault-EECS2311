package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backend.Media;
import backend.Movie;

public class MediaCollectionDB {
	/**
	 * get the media collection associated with a user
	 * @param userid is the userid thats associated with the mediacollection
	 * @return the id of the mediacollection
	 */
	public static int getMediaCollectionId(int userid) {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM mediacollections WHERE userid='"+userid+"';"); //first goes through, if it does not return anything then it means that no collection exists yet (new user)
		try {
			while (result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBC_Connection.execute("INSERT INTO mediacollections(userid) VALUES ("+userid+");"); //create a new mediacollection for the new user
		result = JDBC_Connection.getResult("SELECT * FROM mediacollections WHERE userid='"+userid+"';"); //now get the id that was assigned to the mediacollection
		try {
			while (result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0; //default return incase anything goes wrong
	}
	/**
	 * get the movies held in the media collection
	 * @param collectionid is the collectionid where the movies are stored
	 * @return an ArrayList of Media
	 */
	public static ArrayList<Media> getMediaCollection(int collectionid) {
		ArrayList<Media> collection = new ArrayList<Media>();
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM mediarelations WHERE mediaCollectionID='"+collectionid+"';");
		try {
			while (result.next()) {
				collection.add(new Movie(result.getInt(1)).setStatus(result.getString(3))); //get all the movies for a media collection and store them in collection, also get the status
			}
		} catch (SQLException e) {
		}
		return collection;
	}
	/**
	 * add to the media collection
	 * @param collectionid is the target collection
	 * @param mediaid is the media to be added
	 */
	public static boolean addMediaCollection(int collectionid, int mediaid) {
		return JDBC_Connection.execute("INSERT INTO mediarelations(mediaID,mediaCollectionID,mediaStatus) VALUES ('"+mediaid+"','"+collectionid+"','---');");
	}
	/**
	 * add to the media collection
	 * @param collectionid is the target collection
	 * @param mediaid is the media to be removed
	 */
	public static boolean removeMediaCollection(int collectionid, int mediaid) {
		return JDBC_Connection.execute("DELETE FROM mediarelations WHERE mediaID='"+mediaid+"' AND mediaCollectionID='"+collectionid+"';");
	}
	
	public static boolean setStatus(int collectionid, int mediaid, String oldStatus, String newStatus) {
		return JDBC_Connection.execute("UPDATE mediarelations SET mediaStatus = REPLACE(mediaStatus,'"+oldStatus+"', '"+newStatus+"') WHERE mediaID='"+mediaid+"' AND mediaCollectionID='"+collectionid+"';");
	}
	
}
