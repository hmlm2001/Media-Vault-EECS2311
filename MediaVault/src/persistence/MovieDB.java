package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import backend.Movie;

public class MovieDB {
	public static ResultSet getMovie(int id) throws SQLException {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM allmovies WHERE id='"+id+"';");
		return result;
	}
}
