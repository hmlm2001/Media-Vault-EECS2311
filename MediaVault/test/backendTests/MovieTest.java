package backendTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.Media;
import backend.Movie;
import backend.UseStub;

class MovieTest {

	Movie movie1;
	Movie movie2;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@BeforeEach
	void init() throws ParseException {
		UseStub.setStubFlag(true);
		movie1 = new Movie(505642);
		//Media movie2 = new Movie(0);// invalid id
	}
	
	@Test
	void getIdTest() {
		assertEquals(505642, movie1.getId());
	}
	
	@Test
	void getTitleTest() {
		assertEquals("Black Panther: Wakanda Forever", movie1.getTitle());
	}
	
//	@Test	
//	void getTitleTest2() {
//		assertEquals("Movie2", movie2.getName());
//	}	
	
	@Test
	void getReleaseDateTest() throws ParseException {
		assertEquals(Date.valueOf("2022-11-09"), movie1.getReleaseDate());
	}
	
//	@Test
//	void getReleaseDateTest2() throws ParseException {
//		assertEquals(dateFormat.parse("2021-05-02"), movie2.getReleaseDate());
//	}
//	
	@AfterAll
	void cleanup() {
		UseStub.setStubFlag(false);
	}
}
