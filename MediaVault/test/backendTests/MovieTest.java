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
	
	/**
	 * sets the StubFlag to true in the beginning so the tests are run on the stub database.
	 * And creates the movie objects
	 */
	@BeforeEach
	void init() throws ParseException {
		UseStub.setStubFlag(true);
		movie1 = new Movie(505642);
		movie2 = new Movie(0);
	}
	
	/**
	 * tests if getId returns the correct Id for the movie.
	 */
	@Test
	void getIdTest() {
		assertEquals(505642, movie1.getId());
	}
	
	/**
	 * tests if getTitle returns the correct Title for the movie.
	 */
	@Test
	void getTitleTest() {
		assertEquals("Black Panther: Wakanda Forever", movie1.getTitle());
	}
	
	/**
	 * tests if getOverview returns the correct Overview for the movie.
	 */
	@Test
	void getOverviewTest() {
		assertEquals("Queen Ramonda, Shuri, M’Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King T’Challa’s death.  As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia and Everett Ross and forge a new path for the kingdom of Wakanda.", movie1.getOverview());
	}
	
	/**
	 * tests if getPosterPath returns the correct PosterPath for the movie.
	 */	
	@Test
	void getPosterPathTest() {
		assertEquals("http://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", movie1.getPosterPath());
	}
	
	/**
	 * tests if getGenre returns the correct Genre for the movie.
	 */
	@Test
	void getGenreTest() {
		assertEquals("Action", movie1.getGenre());
	}
	/**
	 * tests if getRuntime returns the correct runtime for the movie.
	 */
	
	@Test
	void getRuntimeTest() {
		assertEquals(162, movie1.getRuntime());
	}
	/**
	 * tests if getReleaseDate returns the correct date for the movie.
	 * @throws ParseException
	 */
	
	@Test
	void getReleaseDateTest() throws ParseException {
		assertEquals("2022-11-09", movie1.getReleaseDate());
	}
	/**
	 * tests for a new movie that's not one of the valid ids in the stub.
	 * defaults to Puss in Boots: The Last Wish, ONLY FOR TESTING.
	 */
	@Test	
	void getTitleTest2() {
		assertEquals("Puss in Boots: The Last Wish", movie2.getTitle());
	}
	/**
	 * tests for a new movie that's not one of the valid ids in the stub.
	 * should return the release date for Puss in Boots: The Last Wish.
	 */
	@Test
	void getReleaseDateTest2() throws ParseException {
		assertEquals("2022-12-07", movie2.getReleaseDate());
	}
	/**
	 * sets the StubFlag to false so testing does not interfere with the normal operation of the project.
	 */
	@AfterAll
	static void cleanup() {
		UseStub.setStubFlag(false);
	}
}
