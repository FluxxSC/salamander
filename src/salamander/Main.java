package salamander;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
	
	private void copyToClipBoard(String text) {
		StringSelection selection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
	}
	
	public void serverUp(String ip, int port) {
		System.out.println("Server lytter p� " + ip + " : " + port + ".");
		//System.out.println("Ip kopiert til utklippstavlen.");
		//copyToClipBoard(""+ip);
	}
	
	
	
	
	
	public static void main(String[] args) {
		new Main();
	}
}
