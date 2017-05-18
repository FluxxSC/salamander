package salamander;

import java.util.Scanner;

public class Game {
	
	public int mode;
	private String word;
	private boolean isOver = false;
	private Scanner input;
	public HangmanDrawer hDrawer;
	private LetterChecking lChecker;

	public void setWord(String word) {
		this.word = word;
		input = new Scanner(System.in);
		lChecker = new LetterChecking();
		lChecker.feedWord(word);
		hDrawer = new HangmanDrawer();
	}
	
	public void printStatus() {
		hDrawer.drawHangman(6);
		System.out.println(lChecker.getProgress());
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
		
		lChecker.letterInput(input);
		lChecker.compareLetters();
	}
	
	public boolean isOver() {
		return isOver;
	}
	
	public void setMode(int mode){
		this.mode = mode;
	}
}
