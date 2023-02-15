package backend;

public class Login {
	/**
	 * Creates a new account
	 * @param username the input username
	 * @param password the input password
	 * @return true if new account has been created, false otherwise
	 */
	public static boolean createAccount(String username, String password) {
		return Encryption.encryptNewAccount(username, password);
	}
	/**
	 * Logs into an already existing account
	 * @param username the input username
	 * @param password the input password
	 * @return true if login is successful, false otherwise
	 */
	public static boolean login(String username, String password) {
		return Encryption.encryptVerifyLogin(username, password);
		
	}
	public static void main(String[] args) {
		System.out.println("Create account Mate with Password 123: " + Login.createAccount("Mate","123"));
		System.out.println("Login to account Matthew with password 123: " + Login.login("Matthew", "123"));
		System.out.println("Login to account Mate with password 1234: " + Login.login("Mate", "1234"));
		System.out.println("Login to account Mate with password 123: " + Login.login("Mate", "123"));
		
	}
}