package backend;

public class Login {
	/**
	 * Creates a new account
	 * @param username the input username
	 * @param password the input password
	 * @return true if new account has been created, false otherwise
	 */
	public static boolean createAccount(String username, String password) {
		return Encryption.encryptNewAccount(username.toLowerCase(), password);
	}
	/**
	 * Logs into an already existing account
	 * @param username the input username
	 * @param password the input password
	 * @return true if login is successful, false otherwise
	 */
	public static boolean login(String username, String password) {
		return Encryption.encryptVerifyLogin(username.toLowerCase(), password);
	}
}