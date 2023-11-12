package esAES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Decifra {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		final String algorithm = "AES";
		try (ServerSocket serverSocket = new ServerSocket(60000)) {
			Socket toClient = serverSocket.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(toClient.getInputStream()));
			String key_base64 = br.readLine();
			String cifrato_base64 = br.readLine();
			byte[] decodedKey = Base64.getDecoder().decode(key_base64.getBytes());
			Key key = new SecretKeySpec(decodedKey, 0, decodedKey.length, algorithm);
			byte[] messaggio_cifrato = Base64.getDecoder().decode(cifrato_base64.getBytes());
			Cipher cipher = Cipher.getInstance(algorithm+"/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			String messaggio = new String(cipher.doFinal(messaggio_cifrato));
			System.out.println(messaggio);
		} catch (IOException e) {}
	}
}
