package persistenceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import backend.UseStub;
import persistence.ActiveConnection;
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
		ActiveConnection activeCon = MovieDB.getMovie(505642);
		ResultSet result = activeCon.result;
		result.next();
		assertEquals(505642,result.getInt(1));
		activeCon.closeConnection();
				
	}
	/**
	 * Tests for non-existant movie
	 * @throws SQLException
	 */
	@Test
	void getMovieTest2() throws SQLException {
		ActiveConnection activeCon = MovieDB.getMovie(00000);
		ResultSet result = activeCon.result;
		assertFalse(result.next());
		activeCon.closeConnection();
				
	}

}
