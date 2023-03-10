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
		assertTrue(LoginDB.newAccount("user55", "5555", "" ));
		System.out.println("this test only passes on the first run since user12 will be recorded on the server and duplicate accounts cannot be made.");
	}
	
	@Test
	void verifyLoginTest() {
		assertTrue(LoginDB.verifyLogin("user55", "5555" ));
	}

}
