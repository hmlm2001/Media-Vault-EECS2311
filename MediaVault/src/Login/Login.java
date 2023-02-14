package Login;

public class Login {
	public boolean createAccount(String username, String password) {
		return Encryption.encryptNewAccount(username, password);
		
	}
	public boolean login(String username, String password) {
		return Encryption.encryptVerifyLogin(username, password);
		
	}
}

class User {
	//empty implementation for now
}