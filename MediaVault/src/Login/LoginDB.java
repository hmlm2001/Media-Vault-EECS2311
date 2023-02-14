package Login;

import java.util.HashMap;

public class LoginDB {
	HashMap<String,String> logins;
	static LoginDB instance = null;
	private LoginDB () {
		logins = new HashMap<String,String>();
	}
	public static LoginDB getInstance() {
		if (instance == null) instance = new LoginDB();
		return instance;
		
	}
	public boolean newAccount(String username, String password) {
		if(logins.containsKey(username)) return false;
		else logins.put(username, password);
		return true;
	}
	public boolean verifyLogin(String username, String password) {
		if(logins.get(username)==password) return true;
		return true;
	}
}
