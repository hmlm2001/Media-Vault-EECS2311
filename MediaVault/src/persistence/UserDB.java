package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
	/**
	 * gets the id associated with a username
	 * @param username is the username of the account
	 * @return the id associated with the username
	 */
	public static int getId(String username) {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT userID FROM users WHERE username='"+username+"';");
		try {
			while (result.next()) {
				return result.getInt(1); //get the id associated with a username
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * gets the username associated with an id
	 * @param id is the id of the account
	 * @return the username associated with the id
	 */
	public static String getUsername(int id) {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT username FROM users WHERE userID='"+id+"';");
		try {
			while (result.next()) {
				return result.getString(1); //get the username associated with an id
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
