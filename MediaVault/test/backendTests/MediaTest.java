package backendTests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.Media;
import backend.UseStub;

class MediaTest {
	
	Media movie1;
	Media movie2;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@BeforeEach
	void init() throws ParseException {
		UseStub.setStubFlag(true);
		movie1 = new Media("Movie1", dateFormat.parse("2022-02-02"));
		movie2 = new Media("Movie2", dateFormat.parse("2021-05-02"));
	}
	
	@Test
	void getNameTest1() {
		assertEquals("Movie1", movie1.getName());
	}
	
	@Test	
	void getNameTest2() {
		assertEquals("Movie2", movie2.getName());
	}	
	
	@Test
	void getReleaseDateTest1() throws ParseException {
		assertEquals(dateFormat.parse("2022-02-02"), movie1.getReleaseDate());
	}
	
	@Test
	void getReleaseDateTest2() throws ParseException {
		assertEquals(dateFormat.parse("2021-05-02"), movie2.getReleaseDate());
	}
	
	@AfterAll
	void cleanup() {
		UseStub.setStubFlag(false);
	}

}
