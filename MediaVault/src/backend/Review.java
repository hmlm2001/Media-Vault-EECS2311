package backend;

import java.util.ArrayList;

import persistence.ReviewDB;

public class Review {
	User user;
	String review;
	
	public Review(User user, String review) {
		this.user=user;
		this.review=review;
		ReviewDB.add(user.getId(), review);
	}
	public static ArrayList<Review> get(Media media){
		return ReviewDB.get(media);
	}
	public static void main(String[] args) {
		
	}
}
