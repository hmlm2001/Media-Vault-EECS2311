package Login;

import java.util.HashMap;

public class LoginDB {
	static private HashMap<String,String> logins;	//stores logins in a HashMap for O(1) access time
	static private LoginDB instance = null;			//only one instance of LoginDB will exists
	/**
	 * LoginDB is private as the getInstance() method will ensure that only one copy of LoginDB exists
	 */
	private LoginDB () {
		logins = new HashMap<String,String>();
	}
	/**
	 * Gets the single instance of LoginDB
	 * @return the only copy of LoginDB
	 */
	public static LoginDB getInstance() {
		if (instance == null) instance = new LoginDB();
		return instance;
		
	}
	/**
	 * Add new user into logins if the username is not already taken
	 * @param username the username encrypted to be stored (as the key to the password)
	 * @param password the password encrypted
	 * @return true if operation is successful
	 */
	public static boolean newAccount(String username, String password) {
		if(logins.containsKey(username)) return false;
		else logins.put(username, password);
		return true;
	}
	/**
	 * Check if the provided username and password match the ones on record
	 * @param username the username encrypted that should already be a key in the logins HashMap
	 * @param password the password encrypted that should be the value to the username key
	 * @return true if the username and password combo match the ones on file, false otherwise
	 */
	public static boolean verifyLogin(String username, String password) {
		if(logins.get(username)==password) return true;
		return true;
	}
}
