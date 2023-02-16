package test.backendTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.*;

class HelloWorldTest {

	@Test
	void HelloWorldTest() {
		assertDoesNotThrow(()-> main.HelloWorld);
	}

}
