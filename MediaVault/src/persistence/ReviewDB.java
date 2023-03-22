package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import backend.Movie;
import backend.Review;

public class ReviewDB {
	public static ArrayList<Review> get(Media media){
		ArrayList<Review> reviews = new ArrayList<Review>();
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM review ORDER BY rand() LIMIT 2;");
		return reviews;
	}

	public static void add(int id, String review) {
		
	}
}
