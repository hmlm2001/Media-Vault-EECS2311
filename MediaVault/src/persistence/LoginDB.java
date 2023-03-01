package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginDB {
	/**
	 * Add new user into logins if the username is not already taken
	 * @param username the username encrypted to be stored (as the key to the password)
	 * @param password the password encrypted
	 * @return true if operation is successful
	 */
	public static boolean newAccount(String username, String password) {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM logins WHERE usernameEnc='"+username+"';");
		try {
			while (result.next()) {
				if(username.compareTo(result.getString(1))==0) return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBC_Connection.execute("INSERT INTO logins(usernameEnc,passwordEnc) VALUES ('"+username+"','"+password+"');");
		return true;
	}
	/**
	 * Check if the provided username and password match the ones on record
	 * @param username the username encrypted that should already be a key in the logins HashMap
	 * @param password the password encrypted that should be the value to the username key
	 * @return true if the username and password combo match the ones on file, false otherwise 
	 */
	public static boolean verifyLogin(String username, String password) {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM logins WHERE usernameEnc='"+username+"';");
		try {
			while (result.next()) {
				return result.getString(2).compareTo(password)==0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
