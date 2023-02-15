package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.*;

class LoginTest {
	
	//Try creating an account
	@Test
	void LoginTest1() {
		assertTrue(Login.createAccount("Mate", "123"));
	}
	
	//Try creating two identical accounts
	@Test
	void LoginTest2() {
		assertTrue(Login.createAccount("Mate", "123"));
		assertFalse(Login.createAccount("Mate", "123"));
		assertTrue(Login.createAccount("Mate", "1234"));
		assertTrue(Login.createAccount("Mates", "123"));
	}
	
	//Try logging in successfully
	@Test
	void LoginTest3() {
		assertTrue(Login.createAccount("Mate", "123"));
		assertTrue(Login.login("Mate", "123"));
	}
	
	//Try logging in unsuccessfully
	@Test
	void LoginTest4() {
		assertTrue(Login.createAccount("Mate", "123"));
		assertFalse(Login.login("Matthew", "123"));
		assertFalse(Login.login("Mate", "1234"));
	}

}
