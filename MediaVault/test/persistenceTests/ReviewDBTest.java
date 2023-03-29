package persistenceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.Movie;
import backend.Review;
import backend.UseStub;
import backend.User;
import persistence.ReviewDB;

class ReviewDBTest {

	/**
	 * Use the real DB
	 * NOTE: All test cases only work assuming no 
	 * other reviews have been added to the
	 * tested movies
	 */
	@BeforeEach 
	void init() {
		UseStub.setStubFlag(false);
	}
	
	/**
	 * Get reviews for a movie
	 */
	@Test
	void getReviewsTest() {
		ArrayList<Review> reviews = ReviewDB.get(new Movie(631842));
		assertNotEquals(reviews, null);
		assertEquals(3, reviews.size());
	}
	
	/**
	 * Get reviews for another movie
	 */
	@Test
	void getReviewsTest2() {
		ArrayList<Review> reviews = ReviewDB.get(new Movie(19995));
		assertNotEquals(reviews, null);
		assertEquals(1, reviews.size());
	}
	
	/**
	 * Testing when the user has not reviewed the movie before
	 */
	@Test
	void userReviewedTest1() {
		assertFalse(ReviewDB.userReviewed(411, "user10"));
	}
	
	/**
	 * Testing when the user has already reviewed the movie
	 */
	@Test
	void userReviewedTest2() {
		assertTrue(ReviewDB.userReviewed(411, "user1"));
	}
	
	/**
	 * Testing the addition of a review to the DB
	 */
	@Test
	void addTest() {
		Review review = new Review(new User("user6"), "This was a great watch!");
		assertTrue(ReviewDB.add(411, review));
	}

}
