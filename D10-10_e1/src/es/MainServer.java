package es;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {
	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(65000)) {
			while(true) {
				new Worker(serverSocket.accept()).start();
			}
		} catch (IOException e) {}
	}
	
}
