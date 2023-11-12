package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MainServer {
	public static void main(String[] args) {
		try (DatagramSocket dSocket = new DatagramSocket(65000)) {
			String input;
			do {
				byte[] inBuffer = new byte[64];
				DatagramPacket inPacket = new DatagramPacket(inBuffer, inBuffer.length);
				dSocket.receive(inPacket);
				input = new String(inBuffer, 0, inPacket.getLength());
				String length = input.length()+"";
				System.out.println("Str: "+input+" - "+length);
				InetAddress address = inPacket.getAddress();
				int port = inPacket.getPort();
				byte[] outBuffer = length.getBytes();
				DatagramPacket outPacket = new DatagramPacket(outBuffer, outBuffer.length, address, port);
				dSocket.send(outPacket);
			} while(!input.equalsIgnoreCase("fine"));
		} 
		catch (SocketException e) {} 
		catch (IOException e) {}

	}
}
