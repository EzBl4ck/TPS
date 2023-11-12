package base64impl;

import java.math.BigInteger;
import java.security.SecureRandom;

public class FBase64 {
	public static void main(String[] args) {
		String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		byte[] byteArray = new byte[3];
		new SecureRandom().nextBytes(byteArray);
		int length = byteArray.length;
		while(length % 6 != 0) {
			length++;
		}
		byte[] b = new byte[length];
		System.arraycopy(byteArray, 0, b, 0, byteArray.length);
		BigInteger bin = new BigInteger(1, b);
		String binario = bin.toString(2);
		String[] groups = binario.split("(?<=\\G.{" + 6 + "})");
		System.out.println(binario);
		for(String s : groups) {
			System.out.print(map.charAt(new BigInteger(s, 2).intValue()));
		}
	}
}
