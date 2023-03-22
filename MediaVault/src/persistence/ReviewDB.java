package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backend.Media;
import backend.Review;
import backend.User;

public class ReviewDB {
	/**
	 * gets a list of reviews associated with a media
	 * @param media is the media under review
	 * @return the array list of media containing 3 reviews
	 */
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
	/**
	 * checks if a user already has a review in the db for the related media
	 * @param movieId is the id of the movie that is getting reviewed
	 * @param username is the username of the user giving the review
	 * @return true if it exists, false otherwise
	 */
	public static boolean userReviewed(int movieId, String username) {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM review WHERE username='"+username+"'AND movieid="+movieId+";");
		try {
			if (result.next() == false) {
			      return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * add a media to the db, overwrite if it exists, insert if it doesnt
	 * @param movieId is the id of the movie being reviewed
	 * @param reviewObj the isntnace of the review
	 * @return true if successful, false otherwise
	 */
	public static boolean add(int movieId, Review reviewObj) {
		String username = reviewObj.getUser().getUsername();
		String review = reviewObj.getReview();
		if (!userReviewed(movieId,username)) {
			JDBC_Connection.execute("INSERT INTO review VALUES ('"+username+"',"+movieId+",'"+review+"');");
		} else {
			JDBC_Connection.execute("REPLACE INTO review VALUES ('"+username+"',"+movieId+",'"+review+"');");
		}
		return true;
	}
}
