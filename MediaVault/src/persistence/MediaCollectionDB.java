package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backend.Media;
import backend.Movie;

public class MediaCollectionDB {
	public static int getMediaCollectionId(int userid) {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM mediacollections WHERE userid='"+userid+"';");
		try {
			while (result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBC_Connection.execute("INSERT INTO mediacollections(userid) VALUES ("+userid+");");
		result = JDBC_Connection.getResult("SELECT * FROM mediacollections WHERE userid='"+userid+"';");
		try {
			while (result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static ArrayList<Media> getMediaCollection(int collectionid) {
		ArrayList<Media> collection = new ArrayList<Media>();
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM mediarelations WHERE mediaCollectionID='"+collectionid+"';");
		try {
			while (result.next()) {
				collection.add(new Movie(result.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collection;
	}
	public static void addMediaCollection(int collectionid, int mediaid) {
		JDBC_Connection.execute("INSERT INTO mediarelations(mediaID,mediaCollectionID) VALUES ('"+mediaid+"','"+collectionid+"');");
	}
	public static void removeMediaCollection(int collectionid, int mediaid) {
		JDBC_Connection.execute("DELETE FROM mediarelations WHERE mediaID='"+mediaid+"' AND mediaCollectionID='"+collectionid+"';");
	}
}
