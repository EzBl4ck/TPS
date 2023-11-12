package es;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Worker extends Thread {
	
	private BufferedReader br = null;
	private PrintWriter pw = null;
	
	public Worker(Socket toClient) {
		try {
			br = new BufferedReader(new InputStreamReader(toClient.getInputStream()));
			pw = new PrintWriter(toClient.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println("Errore apertura stream");
		}
	}
	
	@Override
	public void run() {
		String s;
		do {
			try {
				s = br.readLine();
			} catch (IOException e) { break; }
			int length = s.length();
			System.out.println("Str: "+s+" - "+length);
			pw.println(length);
		} while(!s.equals("fine"));
	}

}
