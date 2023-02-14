package Login;

import java.math.BigInteger;  
import java.nio.charset.StandardCharsets;  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  

public class Encryption {

	public static boolean encryptNewAccount(String username, String password) {
		return LoginDB.getInstance().newAccount(encrypt(username),encrypt(password));
	}
	public static boolean encryptVerifyLogin(String username, String password) {
		return LoginDB.getInstance().verifyLogin(encrypt(username),encrypt(password));;
	}
	private static String encrypt(String input) {
		try {
			return toHexString(getSHA(input));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "ERROR";
	}
	
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException  
    {  
        MessageDigest md = MessageDigest.getInstance("SHA-512");  
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    }  
	public static String toHexString(byte[] hash)  
    {    
        BigInteger number = new BigInteger(1, hash);  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    }  
}
