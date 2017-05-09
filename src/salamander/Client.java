package salamander;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable{
	
	private String address;
	private int port;
	private boolean running = true;
	
	private DataOutputStream outToServer;
	
	public Client(String address, int port) {
		this.address = address;
		this.port = port;
	}
	
	public void run() {
		connect();
	}
	
	private void connect() {
		try {
			Socket clientSocket = new Socket(address, port);
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			while (running) {
				String input = inFromServer.readLine();
				System.out.println("Received from server: " + input);
			}
			clientSocket.close();
			
		} catch (IOException e) {
			System.out.println("Connect error: " + e);
		}
	}
	
	public void send(String command) {
		try {
			System.out.println("Sending to server: " + command);
			outToServer.writeBytes(command + "\n");
		} catch (IOException e) {
			System.out.println("Client sending error: " + e);
		}
		
	}
	
	public void stop() {
		running = false;
	}

}
