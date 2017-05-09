package salamander;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public ArrayList<String> words;
	public Game game;
	
	
	public Main() {
		
		Server server = new Server(6789);
		Client client = new Client("localhost", 6789);
		
		server.start();
		client.start();
		
		Scanner input = new Scanner(System.in);
		
		int a = 0;
		while (a < 10) {
			client.send(input.nextLine());
			a += 1;
		}
		
		
		
		words = new FilLeser().getordliste("ordliste.txt");
		game = new Game();
		//play();
	}
	
	public void play() {
		game.setWord(randomWord());
		System.out.println("Welcome!");
		
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
		return "word";
	}
	
	
	
	
	public static void main(String[] args) {
		new Main();
	}
}
