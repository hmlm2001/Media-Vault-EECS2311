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
}
