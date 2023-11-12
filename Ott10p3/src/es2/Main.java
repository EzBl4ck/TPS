package es2;

import java.security.Security;

public class Main {
	public static void main(String[] args) {
		for(String s : Security.getAlgorithms("MessageDigest")) {
			System.out.println(s);
		}
	}
}
