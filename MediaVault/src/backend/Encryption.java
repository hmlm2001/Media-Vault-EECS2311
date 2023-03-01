package backend;

import java.math.BigInteger;  
import java.nio.charset.StandardCharsets;  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
import persistence.LoginDB;

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
		return LoginDB.verifyLogin(encrypt(username),encrypt(password));
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
	 * @param input is the input string that is to be converted into byte
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
	public static void main(String[] args) {
		System.out.println("INSERT INTO logins(usernameEnc,passwordEnc) VALUES");
		System.out.println("('" + Encryption.encrypt("user1") + "','" + Encryption.encrypt("111")+"'),");
		System.out.println("('" + Encryption.encrypt("user2") + "','" + Encryption.encrypt("222")+"'),");
		System.out.println("('" + Encryption.encrypt("user3") + "','" + Encryption.encrypt("333")+"'),");
		System.out.println("('" + Encryption.encrypt("user4") + "','" + Encryption.encrypt("444")+"'),");
		System.out.println("('" + Encryption.encrypt("user5") + "','" + Encryption.encrypt("555")+"'),");
		System.out.println("('" + Encryption.encrypt("user6") + "','" + Encryption.encrypt("666")+"'),");
		System.out.println("('" + Encryption.encrypt("user7") + "','" + Encryption.encrypt("777")+"'),");
		System.out.println("('" + Encryption.encrypt("user8") + "','" + Encryption.encrypt("888")+"'),");
		System.out.println("('" + Encryption.encrypt("user9") + "','" + Encryption.encrypt("999")+"'),");
		System.out.println("('" + Encryption.encrypt("user10") + "','" + Encryption.encrypt("101010")+"'),");
		System.out.println("('" + Encryption.encrypt("user11") + "','" + Encryption.encrypt("111111")+"');");
	}
}
