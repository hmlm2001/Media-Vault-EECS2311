package backendTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.*;

class LoginTest {
	
	@BeforeEach 
	void init() {
		UseStub.setStubFlag(true);
	}
	//Try creating an account
	@Test
	void LoginTest1() {
		assertTrue(Login.createAccount("Mate", "123"));
	}
	
	//Try creating two identical accounts
	@Test
	void LoginTest2() {
		Login.createAccount("Isaac", "123");
		assertFalse(Login.createAccount("Isaac", "123"));
	}
	
	//Try logging in successfully
	@Test
	void LoginTest3() {
		Login.createAccount("Ruth", "123");
		assertTrue(Login.login("Ruth", "123"));
	}
	
	//Try logging in unsuccessfully
	@Test
	void LoginTest4() {
		Login.createAccount("Herman", "123");
		assertFalse(Login.login("Mohammed", "123"));
		assertFalse(Login.login("Herman", "1234"));
	}
	
	@AfterAll 
	void clean() {
		UseStub.setStubFlag(false);
	}

}
