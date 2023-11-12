package esAES;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class Cifra {
	public static void main(String[] args) throws IOException {
		final String algorithm = "AES";
		final Scanner in = new Scanner(System.in);
		
		System.out.print("Messagio: ");
		String mex = in.next();
		
		System.out.print("Dimensione chiave in bit: ");
		int keyLength = in.nextInt();
		Socket toServer = null;
		try {
			Key key = getSecureRandomKey(algorithm, keyLength);
			Cipher cipher = Cipher.getInstance(algorithm+"/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] cifrato = cipher.doFinal(mex.getBytes());
			String cifrato_base64 = Base64.getEncoder().encodeToString(cifrato);
			String key_base64 = Base64.getEncoder().encodeToString(key.getEncoded());
			
			toServer = new Socket("localhost", 60000);
			PrintWriter pw = new PrintWriter(toServer.getOutputStream(), true);
			pw.println(key_base64);
			pw.println(cifrato_base64);
			
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Algoritmo non supportato");
		} catch (InvalidParameterException e){
			System.out.println("Lunghezza chiave non supportata");
		} catch (NoSuchPaddingException e) {
			System.out.println("Padding non supportato");
		} catch (InvalidKeyException e) {
			System.out.println("Chiave invalida");
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			in.close();
			toServer.close();
		}
		
	}
	
	private static Key getSecureRandomKey(String cipher, int keySize) throws NoSuchAlgorithmException {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance(cipher);
	    keyGenerator.init(keySize);
	    return keyGenerator.generateKey();
	}
}
