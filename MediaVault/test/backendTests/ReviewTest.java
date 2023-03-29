package backendTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.Review;
import backend.UseStub;
import backend.User;

class ReviewTest {
	
	/**
	 * Use the stub DB
	 */
	@BeforeEach 
	void init() {
		UseStub.setStubFlag(true);
	}
	
	/**
	 * Try getting the user's details from a review
	 */
	@Test
	void getUserTest() {
		Review review = new Review(new User("user1"), "I loved this movie!");
		assertEquals("user1", review.getUser().getUsername());
		assertEquals(1, review.getUser().getId());
	}
	
	/**
	 * Try getting the actual review from a review object
	 */
	@Test
	void getReviewTest() {
		Review review = new Review(new User("user1"), "I loved this movie!");
		assertEquals("I loved this movie!", review.getReview());
	}

}
