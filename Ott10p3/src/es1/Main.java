package es1;

import java.security.SecureRandom;
import java.util.Base64;

public class Main {
	public static void main(String[] args) {
		byte[] b = new byte[20];
		new SecureRandom().nextBytes(b);
		String encoded = Base64.getEncoder().encodeToString(b);
		System.out.println(encoded);
	}
}
