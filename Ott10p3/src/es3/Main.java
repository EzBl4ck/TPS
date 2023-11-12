package es3;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Inserisci stringa: ");
		String input = in.next();
		 	
		try {
			System.out.println(getHash(input, "MD5"));
			System.out.println(getHash(input, "SHA-1"));
			System.out.println(getHash(input, "SHA-256"));
		} catch (NoSuchAlgorithmException e) {} 
		
		finally {
			in.close();
		}
	}
	
	private static String getHash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] hash = md.digest(input.getBytes());
        return new StringBuilder(new BigInteger(1, hash).toString(16)).toString();
    }

}
