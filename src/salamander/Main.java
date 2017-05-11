package salamander;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public ArrayList<String> words;
	public Game game;
	public Menu menu;
	
	
	public Main() {
		
		Server server = new Server(6789, this);
		Client client1 = new Client("localhost", 6789, this);
		Client client2 = new Client("localhost", 6789, this);
		
		server.start();
		client1.start();
		client2.start();
		
		//client1.send(new Scanner(System.in).nextLine());
		
		
		
		words = new FilLeser().getordliste("ordliste.txt");
		game = new Game();
		menu = new Menu();
		play();
	}
	
	public void play() {
		System.out.println("Welcome!");
		
		game.setMode(menu.run());
		game.setWord(randomWord());
		
		String input;
		while (!game.isOver()) {
			game.printStatus();
			input = game.getInput();
			game.update(input);
		}
		
		game.printStatus();
		game.printEnd();
		
	}
	
	private String randomWord() {
		words.get(new Random().nextInt(words.size()-1));
		return "word";
	}
	
	public void serverUp(String ip, int port) {
		System.out.println("Server lytter på " + ip + " : " + port + ".");
	}
	
	
	
	
	public static void main(String[] args) {
		new Main();
	}
}
