package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backend.Media;
import backend.Movie;

public class ReccomendationsDB {
	public static ArrayList<Media> get(int mediaCollectionId, int n){
		ArrayList<Media> list = new ArrayList<Media>();
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT title,id, FROM allmovies WHERE id NOT IN(SELECT mediaid FROM mediarelations WHERE mediacollectionid="+mediaCollectionId+") order by rand() limit "+n+";");
		try {
			while (result.next()) {
				Movie movie = new Movie(result.getInt("id"));
				list.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
