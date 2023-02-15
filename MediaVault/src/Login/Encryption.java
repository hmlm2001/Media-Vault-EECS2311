package Login;

import java.math.BigInteger;  
import java.nio.charset.StandardCharsets;  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  

public class Encryption {
	/**
	 * Encrypts a username password pair and sends it to LoginDB (The login database) to createa  new account
	 * @param username the input username
	 * @param password the input password
	 * @return returns true if account creation is successful, false otherwise
	 */
	public static boolean encryptNewAccount(String username, String password) {
		LoginDB.getInstance();
		return LoginDB.newAccount(encrypt(username),encrypt(password));
	}
	/**
	 * Encrypts a username password pair and sends it to LoginDB to verify login
	 * @param username
	 * @param password
	 * @return returns true if the account info matches
	 */
	public static boolean encryptVerifyLogin(String username, String password) {
		LoginDB.getInstance();
		return LoginDB.verifyLogin(encrypt(username),encrypt(password));;
	}
	/**
	 * Encrypts input string using getSHA and toHexString
	 * @param input the input string
	 * @return the encrypted version of the input string
	 */
	private static String encrypt(String input) {
		try {
			return toHexString(getSHA(input));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "ERROR";
	}
	/**
	 * Converts an input string into an array of bytes using SHA-512 encryption
	 * @param input is the input string that is to be convereted into byte
	 * @return the byte form of the input string
	 * @throws NoSuchAlgorithmException
	 */
	private static byte[] getSHA(String input) throws NoSuchAlgorithmException  
    {  
        MessageDigest md = MessageDigest.getInstance("SHA-512"); 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  //convert the input string into bytes and SHA-512
    }  
	/**
	 * Converts an input array of bytes and then converts it to a string
	 * @param hash is the array of input bytes
	 * @return the encrypted string
	 */
	private static String toHexString(byte[] hash)  
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
