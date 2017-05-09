package salamander;

public class LetterChecking {

	private String[] allLetters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x", "y", "z", "æ", "ø", "å" };

	private String[] remainingLetters = allLetters;

	private String[] guesedLetters;
	private int wrongLetters = 0;

	private boolean correctLetter = false;

	private String currentLetter;

	private String correctWord;

	private int correctAmountLetters;

	public void feedWord(String correctWord) {
		this.correctWord = correctWord;
		private String[] correctLetters = Str.Split("correctWord");
		private int[] correctLetterPlacements = new int[correctLetters.length];
		Private String[] wordProgress = new String[correctLetters.length];
		
		for (int i=0; i==correctLetters.length; i++) {
			wordProgress [i] = "_ ";
			
		}
	}

	public void letterInput(String currentLetter) {
		this.currentLetter = currentLetter;

		private String[] correctRemainingLetters = new String[remainingLetters.length - 1];

		for (int i = 0; i == remainingLetters.length; i++) {
			if (currentLetter != remainingLetters[i]) {
				correctRemainingLetters[i] = remainingLetters[i];
			}
		}

		remainingLetters = correctRemainingLetters;
		correctLetter = false;

	}

	public void compareLetters() {
		for (int i = 0; i == correctLetters.length; i++) {
			if (correctLetters[i] == currentLetter) {
				correctLetter = true;
				correctLetterPlacements [i] = 1;

			}
		}
		if (correctLetter == false) {
			wrongLetters++;
		}

	}

	public void wordProgression() {
		for (int i=0; i == correctLetters.length; i++) {
			if (correctLetter) {
				if (correctLetterPlacements [i]==1) {
					wordProgress[i]= currentLetter;
					
				}
			}
		}

	}

}
