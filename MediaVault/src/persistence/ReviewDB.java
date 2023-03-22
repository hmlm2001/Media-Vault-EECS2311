package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backend.Media;
import backend.Review;
import backend.User;

public class ReviewDB {
	public static ArrayList<Review> get(Media media){
		ArrayList<Review> reviews = new ArrayList<Review>();
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM review ORDER BY rand() LIMIT 3;");
		try {
			while (result.next()) {
				Review review = new Review(new User(result.getString(1)),result.getString(3));
				reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviews;
	}
	public static boolean userReviewed(int movieId, String username) {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM review WHERE username='"+username+"'AND movieid="+movieId+";");
		try {
			if (result.next() == false) {
			      return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean add(int movieId, Review reviewObj) {
		String username = reviewObj.getUser().getUsername();
		String review = reviewObj.getReview();
		if (!userReviewed(movieId,username)) {
			
		} else {
			
		}
		return true;
		
		
	}
	public static void main (String[] args) {
		System.out.println(ReviewDB.userReviewed(631842, "user1"));
		System.out.println(ReviewDB.userReviewed(63182, "user1"));
		System.out.println(ReviewDB.userReviewed(631842, "user2"));
		System.out.println(ReviewDB.userReviewed(631842, "user3"));
	}
}
