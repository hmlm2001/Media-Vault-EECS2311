package persistence;

public class MovieDB {
	/**
	 * takes an input of id and returns a tuple from the allmovies
	 * @param id is the input id
	 * @return the result set
	 */
	public static ActiveConnection getMovie(int id) {
		//ResultSet result;
		ActiveConnection activeCon = JDBC_Connection.getResult("SELECT * FROM allmovies WHERE id='"+id+"';");
		
		return activeCon;
	}
}
