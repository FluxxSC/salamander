package salamander;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {
	
	private Thread t;
	private int port;
	private boolean running = true;
	private ArrayList<Listener> listeners;
	
	public Server(int port) {
		this.port = port;
		listeners = new ArrayList<Listener>();
	}
	
	public void run() {
		setup();
	}
	
	private void setup() {
		try {
			System.out.println("Setting up server...");
			ServerSocket serverSocket = new ServerSocket(port);
			while (running) {
				System.out.println("Server listening at port " + port);
				Socket connectionSocket = serverSocket.accept();
				Listener listener = new Listener(connectionSocket);
				listeners.add(listener);
			}
			serverSocket.close();
			
		} catch (IOException e) {
			System.out.println("Error setting up server: " + e);
		}
	}
	
	public void send(String command) {
		for (Listener listener : listeners) {
			listener.send(command);
		}
	}
	
	public void start() {
		if (t == null) {
			t = new Thread(this, "serverThread");
			t.start();
		}
	}
	
	public void stop() {
		running = false;
		for (Listener listener : listeners) {
			listener.stop();
		}
	}
}

class Listener implements Runnable {
	
	private Thread t;
	private boolean running;
	private Socket clientSocket;
	private DataOutputStream outToClient;
	
	public Listener(Socket clientSocket) {
		System.out.println("Listening to client: " + clientSocket);
		this.clientSocket = clientSocket;
		run();
	}
	
	
	public void run() {
		try {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			outToClient = new DataOutputStream(clientSocket.getOutputStream());
			while (running) {
				String input = inFromClient.readLine();
				System.out.println("Received from client: " + input);
			}
			
		} catch (IOException e) {
			System.out.println("Listening error: " + e);
		}
	}
	
	public void send(String command) {
		try {
			System.out.println("Sending to client: " + command);
			outToClient.writeBytes(command + "\n");
		} catch (IOException e) {
			System.out.println("Server sending error: " + e);
		}
	}
	
	public void start() {
		if (t == null) {
			t = new Thread(this, "listenerThread");
		}
	}
	
	public void stop() {
		running = false;
	}
}
