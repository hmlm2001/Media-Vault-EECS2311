package persistenceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import backend.UseStub;
import persistence.MovieDB;

class MovieDBTest {

	@BeforeEach
	void init() {
		UseStub.setStubFlag(false);
	}
	/**
	 * Tests for existing movie
	 * @throws SQLException
	 */
	@Test
	void getMovieTest() throws SQLException {
		ResultSet result = MovieDB.getMovie(505642);
		result.next();
		assertEquals(505642,result.getInt(1));
				
	}
	/**
	 * Tests for non-existant movie
	 * @throws SQLException
	 */
	@Test
	void getMovieTest2() throws SQLException {
		ResultSet result = MovieDB.getMovie(00000);
		assertFalse(result.next());
				
	}

}
