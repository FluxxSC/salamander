package salamander;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable{
	
	private Thread t;
	private String address;
	private int port;
	private boolean running = true;
	private Main main;
	
	private DataOutputStream outToServer;
	
	public Client(String address, int port, Main main) {
		this.address = address;
		this.port = port;
	}
	
	public void run() {
		//System.out.println("setting up client");
		connect();
	}
	
	private void connect() {
		try {
			System.out.println("Connecting to server...");
			Socket clientSocket = new Socket(address, port);
			System.out.println("Connected to server!");
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			while (running) {
				String input = inFromServer.readLine();
				//System.out.println("Received from server: " + input);
				handleMessage(input);
			}
			clientSocket.close();
			
		} catch (IOException e) {
			System.out.println("Connect error: " + e);
		}
	}
	
	private void handleMessage(String message) {
		String[] parts = message.split("\\|");
		Commands command = Commands.is(Integer.parseInt(parts[0]));
		int id = Integer.parseInt(parts[1]);
		String arg = "";
		if (parts.length > 2) arg = parts[2];
		
		switch (command) {
		case ID:
			System.out.println("My new id is: " + id);
			break;
		case NAME:
			break;
		case LETTER:
			break;
		case CHAT:
			break;
		case UNKNOWN:
			System.out.println("Unknown command received: " + message);
			break;
			
		}
	}
	
	public void send(String message) {
		try {
			System.out.println("Sending to server: " + message);
			outToServer.writeBytes(message + "\n");
		} catch (IOException e) {
			System.out.println("Client sending error: " + e);
		}
		
	}
	
	public void start() {
		if (t == null) {
			t = new Thread(this, "clientThread");
			t.start();
		}
	}
	
	public void stop() {
		running = false;
	}
}
