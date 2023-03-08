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
		
	@Test
	void getIdTest() {
		assertEquals(1,UserDB.getId("user1"));
		assertEquals(2,UserDB.getId("user2"));
		
	}

}
