package salamander;

import java.util.Scanner;

public class Game {
	
	public int mode;
	private String word;
	private boolean isOver = false;
	private Scanner input;
	public HangmanDrawer hDrawer;
	//private LetterChecking LChecker;

	public void setWord(String word) {
		this.word = word;
		input = new Scanner(System.in);
		//lChecker = new LetterChecking();
		//LChecker.feedWord(word);
		hDrawer = new HangmanDrawer();
	}
	
	public void printStatus() {
		hDrawer.drawHangman(6);
	}
	
	public void printEnd() {
		System.out.println("Spillet er over!");
	}
	
	public String getInput() {
		String out = "";
		while (out.length() != 1) {
			System.out.print("Hvilken bokstav? ");
			out = input.nextLine();
		}
		return out.toLowerCase();
	}
	
	public void update(String input) {
		
		isOver = true;
	}
	
	public boolean isOver() {
		return isOver;
	}
	
	public void setMode(int mode){
		this.mode = mode;
	}
}
