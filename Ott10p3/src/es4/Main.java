package es4;

import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;

public class Main {
	public static void main(String[] args) {
		
		try {
			byte[] data = Files.readAllBytes(Path.of("/media/5agr14/Capoccia/VSCode-win32-x64-1.82.2.zip"));
			byte[] hash = MessageDigest.getInstance("SHA-256").digest(data);
			System.out.println(new BigInteger(1, hash).toString(16));
		} catch (Exception e) {}
	}

}
