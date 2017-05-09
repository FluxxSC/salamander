package salamander;

public class Main {
	
	public String[] words;
	public Game game;
	
	
	public Main() {
		//words = new WordFetcher().readWords("wordList.txt");
		game = new Game();
		play();
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
