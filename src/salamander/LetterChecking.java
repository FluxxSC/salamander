package salamander;

public class LetterChecking {

	private String[] allLetters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x", "y", "z", "æ", "ø", "å" };
	private int wrongLetters = 0;

	private boolean correctLetter = false;

	private String currentLetter;

	public void feedLetter () {
		private String correctWord = 
	}

	public void letterInput () {
		currentLetter = 
	}

	private String[] correctLetters = Str.Split("correctWord");

	public void compareLetters() {
		for (int i = 0; i == correctLetters.length; i++) {
			if (correctLetters[i] == currentLetter) {
				correctLetter = true;
			}
		}
		if (correctLetter == false) {
			wrongLetters ++;
		}

	}
	
	

}
