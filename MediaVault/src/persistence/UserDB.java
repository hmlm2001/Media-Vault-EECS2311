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
		ActiveConnection activeCon = JDBC_Connection.getResult("SELECT userID FROM users WHERE username='"+username+"';");
		result = activeCon.result;
		try {
			while (result.next()) {
				return result.getInt(1); //get the id associated with a username
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		activeCon.closeConnection();
		return 0;
	}	
	/**
	 * gets the user icon associated with a user
	 * @param username is the username of the user inputted
	 * @return the integer value id of the icon
	 */
	public static int getIcon(String username) { 
		ResultSet result;
		ActiveConnection activeCon = JDBC_Connection.getResult("SELECT userIcon FROM users WHERE username='"+username+"';");
		result = activeCon.result;
		try {
			while (result.next()) {
				return result.getInt(1); //get the id associated with a username
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		activeCon.closeConnection();
		return 0;
	}
	/**
	 * Updates the icon associated with an existing user
	 * @param username is the username of the user
	 * @param icon is the new icon value
	 * @return true if updated successfully, false otherwise
	 */
	public static boolean setIcon(String username, int icon) {
		return JDBC_Connection.execute("UPDATE users SET userIcon="+icon+" WHERE username='"+username+"';");
	}
}
