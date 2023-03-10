package backendTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import backend.*;

class UserTest {
	
	User newUser;
	User existingUser;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	//Test if user works
	@BeforeAll
	static void UserTest0() {
		UseStub.setStubFlag(true);
		assertDoesNotThrow(()-> new User("Mate"));
	}
	
	@BeforeEach
	void init() {
		//UseStub.setStubFlag(true);
		newUser = new User("Mate");
		existingUser = new User("user1");
	}

	/**
	 * Test 1 new user
	 */
	@Test
	void newUserTest() {
		assertTrue(newUser != null);
		assertEquals(newUser.getUsername(), "Mate");
		assertTrue(newUser.getMediaList() != null);
		assertEquals(0,newUser.getMediaList().size());
	}

	/**
	 * Test exixting user
	 */
	@Test
	void existingUserTest() {
		assertTrue(existingUser != null);
		assertEquals(existingUser.getUsername(), "user1");
		assertTrue(existingUser.getMediaList() != null);
		assertEquals(1,existingUser.getMediaList().size());
	}
		
	/**
	 * Test adding media
	 * @throws ParseException
	 */
	@Test
	void UserTest2() throws ParseException {
		assertTrue(newUser != null);
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 0);
		
		Movie media = new Movie(315162);
		
		assertTrue(newUser.addMedia(315162));
		assertTrue(newUser.getMediaList() != null);
		
		assertEquals(newUser.getMediaList().size(), 1);
		
		assertEquals(newUser.getMediaList().get(0).getId(), media.getId());
	}
	
	/**
	 * Test adding duplicate media
	 * @throws ParseException
	 */
	@Test
	void UserTest2_1() throws ParseException {
		assertTrue(newUser != null);
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 0);
		
		
		assertTrue(newUser.addMedia(315162));
		
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 1);
		assertFalse(newUser.addMedia(315162));
	}
	
	/**
	 * Test adding multiple media
	 * @throws ParseException
	 */
	@Test
	void UserTest2_2() throws ParseException {
		assertTrue(newUser != null);
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 0);
		Movie media = new Movie(315162);
		Movie media1 = new Movie(646389);
		assertTrue(newUser.addMedia(315162));
		assertEquals(newUser.getMediaList().size(), 1);
		assertTrue(newUser.addMedia(646389));
		assertEquals(newUser.getMediaList().size(), 2);
		assertEquals(newUser.getMediaList().get(0).getId(), media.getId());
		assertEquals(newUser.getMediaList().get(1).getId(), media1.getId());
	}
	
	/**
	 * Test removing media
	 * @throws ParseException
	 */
	@Test
	void UserTest3() throws ParseException {
		assertTrue(newUser != null);
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 0);
	
		assertTrue(newUser.addMedia(315162));
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 1);
		assertTrue(newUser.removeMedia(315162));
		assertEquals(newUser.getMediaList().size(), 0);
	}
	
	/**
	 * Test removing media that isn't in collection
	 * @throws ParseException
	 */
	@Test
	void UserTest3_1() throws ParseException {
		assertTrue(newUser != null);
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 0);
		
		assertTrue(newUser.addMedia(315162));
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 1);
		assertFalse(newUser.removeMedia(646389));
		assertEquals(newUser.getMediaList().size(), 1);
	}
	
	/**
	 * Test removing media from a collection of multiple media
	 * @throws ParseException
	 */
	@Test
	void UserTest3_2() throws ParseException {
		assertTrue(newUser != null);
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 0);
		
		Movie media = new Movie(315162);
		Movie media1 = new Movie(646389);
		assertTrue(newUser.addMedia(315162));
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 1);
		assertTrue(newUser.addMedia(646389));
		assertEquals(newUser.getMediaList().size(), 2);
		assertEquals(newUser.getMediaList().get(0).getId(), media.getId());
		assertEquals(newUser.getMediaList().get(1).getId(), media1.getId());
		assertTrue(newUser.removeMedia(315162));
		assertEquals(newUser.getMediaList().size(), 1);
		assertEquals(newUser.getMediaList().get(0).getId(), media1.getId());
	}
	
	/**
	 * Test two users
	 */
	@Test
	void UserTest4() {
		assertTrue(newUser != null);
		assertEquals(newUser.getUsername(), "Mate");
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 0);
		User user1 = new User("Herman");
		assertTrue(user1 != null);
		assertEquals(user1.getUsername(), "Herman");
		assertTrue(user1.getMediaList() != null);
		assertEquals(user1.getMediaList().size(), 0);
		assertTrue(newUser != user1);
		assertFalse(newUser.getUsername().equals(user1.getUsername()));
		assertFalse(newUser.getMediaList() == user1.getMediaList());
	}
	
	/**
	 * Test two users with different collections sizes
	 * @throws ParseException
	 */
	@Test
	void UserTest4_1() throws ParseException {
		assertTrue(newUser != null);
		assertEquals(newUser.getUsername(), "Mate");
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 0);
		User user1 = new User("Herman");
		assertTrue(user1 != null);
		assertEquals(user1.getUsername(), "Herman");
		assertTrue(user1.getMediaList() != null);
		assertEquals(user1.getMediaList().size(), 0);
		assertTrue(newUser != user1);
		assertFalse(newUser.getUsername().equals(user1.getUsername()));
		assertFalse(newUser.getMediaList() == user1.getMediaList());
		
		assertTrue(newUser.addMedia(315162));
		assertEquals(1, newUser.getMediaList().size());
		assertEquals(0, user1.getMediaList().size());
		assertFalse(newUser.getMediaList() == user1.getMediaList());
	}
	
	/**
	 * Test two users with different media
	 * @throws ParseException
	 */
	@Test
	void UserTest4_2() throws ParseException {
		assertTrue(newUser != null);
		assertEquals(newUser.getUsername(), "Mate");
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 0);
		User user1 = new User("Herman");
		assertTrue(user1 != null);
		assertEquals(user1.getUsername(), "Herman");
		assertTrue(user1.getMediaList() != null);
		assertEquals(user1.getMediaList().size(), 0);
		assertTrue(newUser != user1);
		assertFalse(newUser.getUsername().equals(user1.getUsername()));
		assertFalse(newUser.getMediaList() == user1.getMediaList());
		
		assertTrue(newUser.addMedia(315162));
		
		assertTrue(user1.addMedia(646389));
		assertEquals(newUser.getMediaList().size(), 1);
		assertEquals(user1.getMediaList().size(), 1);
		assertFalse(newUser.getMediaList() == user1.getMediaList());
		assertFalse(newUser.getMediaList().get(0) == user1.getMediaList().get(0));
	}
		
	/**
	 * Test two users with the same media
	 * @throws ParseException
	 */
	@Test
	void UserTest4_3() throws ParseException {
		assertTrue(newUser != null);
		assertEquals(newUser.getUsername(), "Mate");
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 0);
		User user1 = new User("Herman");
		assertTrue(user1 != null);
		assertEquals(user1.getUsername(), "Herman");
		assertTrue(user1.getMediaList() != null);
		assertEquals(user1.getMediaList().size(), 0);
		assertTrue(newUser != user1);
		assertFalse(newUser.getUsername().equals(user1.getUsername()));
		assertFalse(newUser.getMediaList() == user1.getMediaList());
		
		assertTrue(newUser.addMedia(315162));
		assertTrue(user1.addMedia(315162));
		assertEquals(newUser.getMediaList().size(), 1);
		assertEquals(user1.getMediaList().size(), 1);
		assertFalse(newUser.getMediaList() == user1.getMediaList());
		assertTrue(newUser.getMediaList().get(0).getId() == user1.getMediaList().get(0).getId());
	}
		
	/**
	 * Test removing media from one of two users
	 * @throws ParseException
	 */
	@Test
	void UserTest4_4() throws ParseException {
		assertTrue(newUser != null);
		assertEquals(newUser.getUsername(), "Mate");
		assertTrue(newUser.getMediaList() != null);
		assertEquals(newUser.getMediaList().size(), 0);
		User user1 = new User("Herman");
		assertTrue(user1 != null);
		assertEquals(user1.getUsername(), "Herman");
		assertTrue(user1.getMediaList() != null);
		assertEquals(user1.getMediaList().size(), 0);
		assertTrue(newUser != user1);
		assertFalse(newUser.getUsername().equals(user1.getUsername()));
		assertFalse(newUser.getMediaList() == user1.getMediaList());
		assertTrue(newUser.addMedia(315162));
		assertTrue(user1.addMedia(315162));
		assertEquals(newUser.getMediaList().size(), 1);
		assertEquals(user1.getMediaList().size(), 1);
		assertFalse(newUser.getMediaList() == user1.getMediaList());
		assertTrue(newUser.removeMedia(315162));
		assertEquals(newUser.getMediaList().size(), 0);
		assertEquals(user1.getMediaList().size(), 1);
		assertFalse(newUser.getMediaList() == user1.getMediaList());
	}
	
	@AfterAll
	static void cleanup() {
		UseStub.setStubFlag(false);
	}
	
}
