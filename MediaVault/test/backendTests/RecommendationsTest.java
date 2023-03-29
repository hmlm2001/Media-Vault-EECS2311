package backendTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.Media;
import backend.Recommendations;
import backend.UseStub;
import backend.User;

class RecommendationsTest {

	/**
	 * Use the stub DB
	 */
	@BeforeEach 
	void init() {
		UseStub.setStubFlag(true);
	}
	
	/**
	 * Get recommendations for a user to 
	 * ensure it isn't null
	 */
	@Test
	void getRecommendationsTest1() {
		assertNotEquals(Recommendations.get(new User("user1"), 3), null);
	}
	
	/**
	 * Compare two different recommendations to 
	 * ensure they're not the same
	 */
	@Test
	void getRecommendationsTest2() {
		ArrayList<Media> recommendations1 = Recommendations.get(new User("user1"), 5);
		ArrayList<Media> recommendations2 = Recommendations.get(new User("user2"), 5);
		assertNotEquals(recommendations1, recommendations2);
	}

}
