package persistenceTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.UseStub;
import persistence.LoginDB;

class LoginDBTest {

	@BeforeEach
	void init() {
		UseStub.setStubFlag(false);
	}
	
	@Test
	void newAccountTest() {
		assertTrue(LoginDB.newAccount("user12", "1212", "" ));
	}
	
	@Test
	void verifyLoginTest() {
		assertTrue(LoginDB.verifyLogin("user12", "1212" ));
	}

}
