package es;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainClient {
	public static void main(String[] args) {
		try (Socket toServer = new Socket("localhost", 65000); Scanner in = new Scanner(System.in)) {
			BufferedReader br = new BufferedReader(new InputStreamReader(toServer.getInputStream()));
			PrintWriter pw = new PrintWriter(toServer.getOutputStream(), true);
			String s;
			do {
				System.out.println("Stringa: ");
				s = in.next();
				pw.println(s);
				System.out.println("La lunghezza è: "+br.readLine());
			} while(!s.equals("fine"));
		} 
		catch (UnknownHostException e) {} 
		catch (IOException e) {}
		
	}
}
