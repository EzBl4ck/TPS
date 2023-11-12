package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class MainClient {
	public static void main(String[] args) {
		try (DatagramSocket dSocket = new DatagramSocket(60000)) {
			byte[] inBuffer = new byte[64];
			Scanner in = new Scanner(System.in);
			String input;
			
			do {
				System.out.println("Stringa: ");
				input = in.next();
				byte[] outBuffer = input.getBytes();
				DatagramPacket outPacket = new DatagramPacket(outBuffer, outBuffer.length, 
						new InetSocketAddress("localhost", 65000));
				dSocket.send(outPacket);
				DatagramPacket inPacket = new DatagramPacket(inBuffer, inBuffer.length);
				dSocket.receive(inPacket);
				String length = new String(inBuffer);
				System.out.println("La lunghezza è: "+length);
			} while(!input.equalsIgnoreCase("fine"));
			in.close();
		} 
		catch (SocketException e) {} 
		catch (IOException e) {}
	}
}
