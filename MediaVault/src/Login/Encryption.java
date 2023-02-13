package Login;

import java.math.BigInteger;  
import java.nio.charset.StandardCharsets;  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  

public class Encryption {
	public boolean newAccount(String username, String password) {
		return true;
	}
	public boolean verifyLogin(String username, String password) {
		return true;
	}
	private String encrpytUsername(String username) {
		return encryptString(username);
		
	}
	private static String encryptPassword(String password) {
		return encryptString(password);
		
	}
	private static String encryptString(String input) {
		try {
			return toHexString(getSHA(input));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
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
	public static void main(String[] args) {
		String pass = "Hello";
		System.out.println(encryptPassword(pass));
	}
}
