package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistence.JDBC_Connection;

public class Recommendations {
	private Recommendations() {
		
	}
	public static ArrayList<Media> get(int mediaCollectonId, int n){
		ArrayList<Media> list = new ArrayList<Media>();
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT title,id, FROM allmovies WHERE id NOT IN(SELECT mediaid FROM mediarelations WHERE mediacollectionid="+mediaCollectonId+") order by rand() limit "+n+";");
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
//SELECT title,id, FROM allmovies WHERE id NOT IN(SELECT mediaid FROM mediarelations WHERE mediacollectionid=1) order by rand() limit 4;