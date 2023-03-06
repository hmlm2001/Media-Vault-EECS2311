package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import backend.UseStub;

public class LoginDB extends UseStub{
	static HashMap<String, String> logins;
	/**
	 * Add new user into logins if the username is not already taken
	 * @param username the username encrypted to be stored (as the key to the password)
	 * @param password the password encrypted
	 * @return true if operation is successful
	 */
	public static boolean newAccount(String username, String password) {
		if (UseStub.getStubFlag()) {
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
		} else {
			if (logins==null) LoginDB.createStubLogins();
			if (logins.get(username)!=null) {
				return false;
			} else {
				logins.put(username,password);
			}
		}
		return false;
	}
	/**
	 * Check if the provided username and password match the ones on record
	 * @param username the username encrypted that should already be a key in the logins HashMap
	 * @param password the password encrypted that should be the value to the username key
	 * @return true if the username and password combo match the ones on file, false otherwise 
	 */
	public static boolean verifyLogin(String username, String password) {
		if (UseStub.getStubFlag()) {
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
		} else {
			if (logins==null) LoginDB.createStubLogins();
			if (logins.get(username)==null) return false;
			if (logins.get(username).compareTo(password)==0) return true;
		}
		return false;
	}
	private static void createStubLogins() {
		logins=new HashMap<String,String>();
		logins.put("9ec62c20118ff506dac139ec30a521d12b9883e55da92b7d9adeefe09ed4e0bd152e2a099339871424263784f8103391f83b781c432f45eccb03e18e28060d2f", "fb131bc57a477c8c9d068f1ee5622ac304195a77164ccc2d75d82dfe1a727ba8d674ed87f96143b2b416aacefb555e3045c356faa23e6d21de72b85822e39fdd");
		logins.put("291116775902b38dd09587ad6235cec503fc14dbf9c09cad761f2e5a5755102eaceb54b95ffd179c22652c3910dbc6ed85ddde7e09eef1ecf3ad219225f509f5", "5f28f24f5520230fd1e66ea6ac649e9f9637515f516b2ef74fc90622b60f165eafca8f34db8471b85b9b4a2cdf72f75099ae0eb8860c4f339252261778d406eb");
		logins.put("8ac4145c8e388ddfe3cd94886f026260d917cab07903c533f3a26945019bc4a50e6f23f266acbb0cbae89130fa3242c9a5145e4218c3ef1deebccb58d1a64a43", "5e3155774d39d97c5f9e17c108c2b3e0485a43ae34ebd196f61a6f8bf732ef71a49e5710594cfc7391db114edf99f5da3ed96ef1d6ca5e598e85f91bd41e7eeb");
	}
}
