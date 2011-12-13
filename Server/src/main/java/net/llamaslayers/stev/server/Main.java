package net.llamaslayers.stev.server;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = new Server(57345);
		Thread serverThread = new Thread(server);
		serverThread.start();
		serverThread.join();
	}
}
