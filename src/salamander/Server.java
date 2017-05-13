package salamander;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

public class Server implements Runnable {

	private Main main;
	private Thread t;
	private int port;
	private boolean running = true;
	private Hashtable<Integer, Listener> listeners;
	private int listenerId = 0;

	public Server(int port, Main main) {
		this.port = port;
		this.main = main;
		listeners = new Hashtable<Integer, Listener>();
	}

	public void run() {
		setup();
	}

	private void setup() {
		String myIp = getIp();
		try {
			//System.out.println("Setting up server...");
			ServerSocket serverSocket = new ServerSocket(port);
			main.serverUp(myIp, port);
			while (running) {
				//System.out.println("Server listening at port " + port);
				Socket connectionSocket = serverSocket.accept();
				
				Listener listener = new Listener(connectionSocket, this);
				listener.start();
				listeners.put(listenerId, listener);
				listener.send(Commands.ID.make(listenerId));
				listenerId++;
			}
			serverSocket.close();

		} catch (IOException e) {
			System.out.println("Error setting up server: " + e);
		}
	}

	public void send(String command) {
		for (int i : listeners.keySet()) {
			listeners.get(i).send(command);
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
		for (int i : listeners.keySet()) {
			listeners.get(i).stop();
		}
	}
	
	private String getIp() {
		try {
			URL checkIp = new URL("http://checkip.amazonaws.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(checkIp.openStream()));
			String ip = in.readLine();
			return ip.toString();
		} catch (MalformedURLException e) {
			System.out.println("URL error: " + e);
		} catch (IOException e) {
			System.out.println("Open stream exception: " + e);
		}
		return null;
		
	}
}

class Listener implements Runnable {

	private Thread t;
	private boolean running = true;
	private Socket clientSocket;
	private Server server;
	private DataOutputStream outToClient;

	public Listener(Socket clientSocket, Server server) {
		this.clientSocket = clientSocket;
		this.server = server;
	}

	public void run() {
		//System.out.println("Starting listener...");
		listen();
	}

	public void listen() {
		try {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			outToClient = new DataOutputStream(clientSocket.getOutputStream());
			while (running) {
				//System.out.println("Listening to client: " + clientSocket);
				String input = inFromClient.readLine();
				System.out.println("Received from client: " + input);
				server.send(input);

			}

		} catch (IOException e) {
			System.out.println("Listening error: " + e);
		}
	}

	public void send(String message) {
		try {
			while (outToClient == null) {
				//System.out.println(".");
			}
			//System.out.println("Sending to client: " + command);
			outToClient.writeBytes(message + "\n");
		} catch (IOException e) {
			System.out.println("Server sending error: " + e);
		}
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, "listenerThread");
			t.start();
		}
	}

	public void stop() {
		running = false;
	}
}
