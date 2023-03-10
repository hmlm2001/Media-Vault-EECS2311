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
		System.out.println("This test only passes on the first run since user55 will be recorded on the server and duplicate accounts cannot be made.");
	}
	
	@Test
	void verifyLoginTest() {
		assertTrue(LoginDB.verifyLogin("user55", "5555" ));
		System.out.println("This test only passes on the second run since user55 will be have to be created first before it can be used as a login.");
	}

}
