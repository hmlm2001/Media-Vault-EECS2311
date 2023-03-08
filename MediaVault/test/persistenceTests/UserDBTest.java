package persistenceTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.UseStub;
import persistence.UserDB;

class UserDBTest {

	@BeforeEach
	void init() {
		UseStub.setStubFlag(false);
	}
	/**
	 * Tests if getId returns the correct userid.
	 */
	@Test
	void getIdTest() {
		assertEquals(1,UserDB.getId("user1"));
		assertEquals(2,UserDB.getId("user2"));		
	}
	
	/**
	 * Tests if getId returns 0 for a non existent user. 
	 */
	@Test
	void getIdTest2() {
		assertEquals(0,UserDB.getId("user"));
		assertEquals(0,UserDB.getId("123"));		
	}

}
