package backend;

import java.util.ArrayList;

import persistence.ReviewDB;

public class Review {
	private User user;
	private String review;
	
	public Review(User user, String review) {
		this.user=user;
		this.review=review;
	}
	public static ArrayList<Review> get(Media media){
		return ReviewDB.get(media);
	}
	public static boolean add(Media media, Review review) {
		return ReviewDB.add(media.getId(), review);
	}
	public User getUser() {
		return this.user;
	}
	public String getReview() {
		return this.review;
	}
}
