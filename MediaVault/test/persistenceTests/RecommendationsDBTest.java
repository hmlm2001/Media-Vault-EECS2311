package persistenceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.Media;
import backend.Recommendations;
import backend.UseStub;
import backend.User;

class RecommendationsDBTest {

	/**
	 * Use the real DB
	 */
	@BeforeEach 
	void init() {
		UseStub.setStubFlag(false);
	}
	
	/**
	 * Get recommendations for a user to 
	 * ensure it isn't null
	 */
	@Test
	void getRecommendationsTest1() {
		assertNotEquals(Recommendations.get(new User("user1"), 5), null);
	}
	
	/**
	 * Compare two different recommendations to 
	 * ensure they're not the same
	 */
	@Test
	void getRecommendationsTest2() {
		ArrayList<Media> recommendations1 = Recommendations.get(new User("user1"), 10);
		ArrayList<Media> recommendations2 = Recommendations.get(new User("user2"), 10);
		assertNotEquals(recommendations1, recommendations2);
	}

}
