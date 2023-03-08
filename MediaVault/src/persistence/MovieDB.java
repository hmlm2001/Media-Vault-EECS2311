package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import backend.Movie;

public class MovieDB {
	/**
	 * takes an input of id and returns a tuple from the allmovies
	 * @param id is the input id
	 * @return the result set
	 */
	public static ResultSet getMovie(int id) {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM allmovies WHERE id='"+id+"';");
		return result;
	}
}
