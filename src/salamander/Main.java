package salamander;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	public ArrayList<String> words;
	public Game game;
	public Menu menu;
	
	
	public Main() {
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
	
	
	
	
	public static void main(String[] args) {
		new Main();
	}
}
