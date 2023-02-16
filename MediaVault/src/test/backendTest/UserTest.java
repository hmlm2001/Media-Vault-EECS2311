package test.backendTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.*;

class UserTest {
	
	User user;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	//Test if user works
	@BeforeAll
	static void UserTest0() {
		assertDoesNotThrow(()-> new User("Mate"));
	}
	
	@BeforeEach
	void init() {
		user = new User("Mate");
	}

	//Test 1 user
	@Test
	void UserTest1() {
		assertTrue(user != null);
		assertEquals(user.getUsername(), "Mate");
		assertTrue(user.getMediaList() != null);
		assertEquals(user.getMediaList().size(), 0);
	}
	
	//Test adding media
	@Test
	void UserTest2() {
		assertTrue(user != null);
		assertTrue(user.getMediaList() != null);
		assertEquals(user.getMediaList().size(), 0);
		Date date = dateFormat.parse("2010-03-26");
		Media media = new Media("How To Train Your Dragon", date);
		assertTrue(user.addMedia(media));
		assertTrue(user.getMediaList() != null);
		assertEquals(user.getMediaList().size(), 1);
		assertEquals(user.getMediaList().get(0), media);
	}
	
	//Test adding media already in
	@Test
	void UserTest2_1() {
		assertTrue(user != null);
		assertTrue(user.getMediaList() != null);
		assertEquals(user.getMediaList().size(), 0);
		Date date = dateFormat.parse("2010-03-26");
		Media media = new Media("How To Train Your Dragon", date);
		assertTrue(user.addMedia(media));
		assertTrue(user.getMediaList() != null);
		assertEquals(user.getMediaList().size(), 1);
		assertThrows(IllegalArgumentException.class, ()-> user.addMedia(media));
	}
	
	//Test adding multiple media
	@Test
	void UserTest2_2() {
		assertTrue(user != null);
		assertTrue(user.getMediaList() != null);
		assertEquals(user.getMediaList().size(), 0);
		Media media = new Media("How To Train Your Dragon", dateFormat.parse("2010-03-26"));
		Media media1 = new Media("How To Train Your Dragon 2", dateFormat.parse("2014-06-13"));
		assertTrue(user.addMedia(media));
		assertEquals(user.getMediaList().size(), 1);
		assertTrue(user.addMedia(media1));
		assertEquals(user.getMediaList().size(), 2);
		assertEquals(user.getMediaList().get(0), media);
		assertEquals(user.getMediaList().get(1), media1);
	}
	
	//Test removing media
	@Test
	void UserTest3() {
		assertTrue(user != null);
		assertTrue(user.getMediaList() != null);
		assertEquals(user.getMediaList().size(), 0);
		Date date = dateFormat.parse("2010-03-26");
		Media media = new Media("How To Train Your Dragon", date);
		assertTrue(user.addMedia(media));
		assertTrue(user.getMediaList() != null);
		assertEquals(user.getMediaList().size(), 1);
		assertTrue(user.removeMedia(media));
		assertEquals(user.getMediaList().size(), 0);
	}
	
	//Test removing media that isn't in collection
		@Test
		void UserTest3_1() {
			assertTrue(user != null);
			assertTrue(user.getMediaList() != null);
			assertEquals(user.getMediaList().size(), 0);
			Date date = dateFormat.parse("2010-03-26");
			Media media = new Media("How To Train Your Dragon", date);
			assertTrue(user.addMedia(media));
			assertTrue(user.getMediaList() != null);
			assertEquals(user.getMediaList().size(), 1);
			assertFalse(user.removeMedia(new Media("How To Train Your Dragon 2", dateFormat.parse("2014-06-13"))));
			assertEquals(user.getMediaList().size(), 1);
		}
		
		//Test removing media from a collection of multiple media
		@Test
		void UserTest3_2() {
			assertTrue(user != null);
			assertTrue(user.getMediaList() != null);
			assertEquals(user.getMediaList().size(), 0);
			Date date = dateFormat.parse("2010-03-26");
			Media media = new Media("How To Train Your Dragon", date);
			Media media1 = new Media("How To Train Your Dragon 2", dateFormat.parse("2014-06-13"));
			assertTrue(user.addMedia(media));
			assertTrue(user.getMediaList() != null);
			assertEquals(user.getMediaList().size(), 1);
			assertTrue(user.addMedia(media1));
			assertEquals(user.getMediaList().size(), 2);
			assertEquals(user.getMediaList().get(0), media);
			assertEquals(user.getMediaList().get(1), media1);
			assertTrue(user.removeMedia(media));
			assertEquals(user.getMediaList().size(), 1);
			assertEquals(user.getMediaList().get(0), media1);
		}
	
	//Test two users
	@Test
	void UserTest4() {
		assertTrue(user != null);
		assertEquals(user.getUsername(), "Mate");
		assertTrue(user.getMediaList() != null);
		assertEquals(user.getMediaList().size(), 0);
		User user1;
		assertDoesNotThrow(()-> user1 = new User("Herman"));
		assertTrue(user1 != null);
		assertEquals(user1.getUsername(), "Herman");
		assertTrue(user1.getMediaList() != null);
		assertEquals(user1.getMediaList().size(), 0);
		assertTrue(user != user1);
		assertFalse(user.getUsername().equals(user1.getUsername()));
		assertFalse(user.getMediaList() == user1.getMediaList());
	}
	
	//Test two users with different collections sizes
		@Test
		void UserTest4_1() {
			assertTrue(user != null);
			assertEquals(user.getUsername(), "Mate");
			assertTrue(user.getMediaList() != null);
			assertEquals(user.getMediaList().size(), 0);
			User user1;
			assertDoesNotThrow(()-> user1 = new User("Herman"));
			assertTrue(user1 != null);
			assertEquals(user1.getUsername(), "Herman");
			assertTrue(user1.getMediaList() != null);
			assertEquals(user1.getMediaList().size(), 0);
			assertTrue(user != user1);
			assertFalse(user.getUsername().equals(user1.getUsername()));
			assertFalse(user.getMediaList() == user1.getMediaList());
			Media media = new Media("How To Train Your Dragon", dateFormat.parse("2010-03-26"));
			assertTrue(user1.addMedia(media));
			assertEquals(user.getMediaList().size(), 1);
			assertEquals(user1.getMediaList().size(), 0);
			assertFalse(user.getMediaList() == user1.getMediaList());
		}
	
	//Test two users with different media
		@Test
		void UserTest4_2() {
			assertTrue(user != null);
			assertEquals(user.getUsername(), "Mate");
			assertTrue(user.getMediaList() != null);
			assertEquals(user.getMediaList().size(), 0);
			User user1;
			assertDoesNotThrow(()-> user1 = new User("Herman"));
			assertTrue(user1 != null);
			assertEquals(user1.getUsername(), "Herman");
			assertTrue(user1.getMediaList() != null);
			assertEquals(user1.getMediaList().size(), 0);
			assertTrue(user != user1);
			assertFalse(user.getUsername().equals(user1.getUsername()));
			assertFalse(user.getMediaList() == user1.getMediaList());
			Media media = new Media("How To Train Your Dragon", dateFormat.parse("2010-03-26"));
			assertTrue(user1.addMedia(media));
			Media media1 = new Media("How To Train Your Dragon 2", dateFormat.parse("2014-06-13"));
			assertTrue(user1.addMedia(media1));
			assertEquals(user.getMediaList().size(), 1);
			assertEquals(user1.getMediaList().size(), 1);
			assertFalse(user.getMediaList() == user1.getMediaList());
			assertFalse(user.getMediaList().get(0) == user1.getMediaList().get(0));
		}
		
		//Test two users with the same media
		@Test
		void UserTest4_3() {
			assertTrue(user != null);
			assertEquals(user.getUsername(), "Mate");
			assertTrue(user.getMediaList() != null);
			assertEquals(user.getMediaList().size(), 0);
			User user1;
			assertDoesNotThrow(()-> user1 = new User("Herman"));
			assertTrue(user1 != null);
			assertEquals(user1.getUsername(), "Herman");
			assertTrue(user1.getMediaList() != null);
			assertEquals(user1.getMediaList().size(), 0);
			assertTrue(user != user1);
			assertFalse(user.getUsername().equals(user1.getUsername()));
			assertFalse(user.getMediaList() == user1.getMediaList());
			Media media = new Media("How To Train Your Dragon", dateFormat.parse("2010-03-26"));
			assertTrue(user.addMedia(media));
			assertTrue(user1.addMedia(media));
			assertEquals(user.getMediaList().size(), 1);
			assertEquals(user1.getMediaList().size(), 1);
			assertFalse(user.getMediaList() == user1.getMediaList());
			assertTrue(user.getMediaList().get(0) == user1.getMediaList().get(0));
		}
		
		//Test removing media from one of two users
		@Test
		void UserTest4_4() {
			assertTrue(user != null);
			assertEquals(user.getUsername(), "Mate");
			assertTrue(user.getMediaList() != null);
			assertEquals(user.getMediaList().size(), 0);
			User user1;
			assertDoesNotThrow(()-> user1 = new User("Herman"));
			assertTrue(user1 != null);
			assertEquals(user1.getUsername(), "Herman");
			assertTrue(user1.getMediaList() != null);
			assertEquals(user1.getMediaList().size(), 0);
			assertTrue(user != user1);
			assertFalse(user.getUsername().equals(user1.getUsername()));
			assertFalse(user.getMediaList() == user1.getMediaList());
			Media media = new Media("How To Train Your Dragon", dateFormat.parse("2010-03-26"));
			assertTrue(user.addMedia(media));
			assertTrue(user1.addMedia(media));
			assertEquals(user.getMediaList().size(), 1);
			assertEquals(user1.getMediaList().size(), 1);
			assertFalse(user.getMediaList() == user1.getMediaList());
			assertTrue(user.removeMedia(media));
			assertEquals(user.getMediaList().size(), 0);
			assertEquals(user1.getMediaList().size(), 1);
			assertFalse(user.getMediaList() == user1.getMediaList());
		}
	
}
