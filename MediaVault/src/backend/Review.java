package backend;

import java.util.ArrayList;

import persistence.ReviewDB;

public class Review {
	private User user;
	private String review;
	/**
	 * Create a review object which holds a user and the review text
	 * @param user is the user that is associated with the review
	 * @param review is the block of text that is the review
	 */
	public Review(User user, String review) {
		this.user=user;
		this.review=review;
		if (review.contains("'")) this.review = "---";
	}
	/**
	 * Get an array list containing 3 random reviews from the DB
	 * @param media is the media which the reviews are under
	 * @return is the array list containing the reviews
	 */
	public static ArrayList<Review> get(Media media){
		return ReviewDB.get(media);
	}
	/**
	 * Add a piece of media to the review DB associated with a movie
	 * @param media is the media under which the review is to be added
	 * @param review is the review to be added to the db
	 * @return true if operation successful, false otherwise
	 */
	public static boolean add(Media media, Review review) {
		return ReviewDB.add(media.getId(), review);
	}
	/**
	 * get the user associated to the review object
	 * @return the user
	 */
	public User getUser() {
		return this.user;
	}
	/**
	 * get the string review associated to the review object
	 * @return
	 */
	public String getReview() {
		return this.review;
	}
}
