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
		
	@Test
	void getMovieTest() throws SQLException {
		ResultSet result = MovieDB.getMovie(505642);
		result.next();
		assertEquals(505642,result.getInt(1));
				
	}

}
