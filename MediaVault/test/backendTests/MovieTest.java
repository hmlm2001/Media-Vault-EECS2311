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
	
	@Test
	void getOverviewTest() {
		assertEquals("Queen Ramonda, Shuri, M’Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King T’Challa’s death.  As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia and Everett Ross and forge a new path for the kingdom of Wakanda.", movie1.getOverview());
	}
	
	@Test
	void getPosterPathTest() {
		assertEquals("http://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", movie1.getPosterPath());
	}
	
	@Test
	void getGenreTest() {
		assertEquals("Action", movie1.getGenre());
	}
	@Test
	void getRuntimeTest() {
		assertEquals(162, movie1.getRuntime());
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
	static void cleanup() {
		UseStub.setStubFlag(false);
	}
}
