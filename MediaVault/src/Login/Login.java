package Login;

public class Login {
	/**
	 * Creates a new account
	 * @param username the input username
	 * @param password the input password
	 * @return true if new account has been created, false otherwise
	 */
	public boolean createAccount(String username, String password) {
		return Encryption.encryptNewAccount(username, password);
	}
	/**
	 * Logs into an already existing account
	 * @param username the input username
	 * @param password the input password
	 * @return true if login is successful, false otherwise
	 */
	public boolean login(String username, String password) {
		return Encryption.encryptVerifyLogin(username, password);
		
	}
}