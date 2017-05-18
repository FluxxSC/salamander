package salamander;

public class LetterChecking {

	// Lager en liste med alle bokstaver. 
	
	private String[] allLetters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x", "y", "z", "æ", "ø", "å" };
	private String[] remainingLetters = allLetters;

	// Ubrukt variabel som evt kan lage en liste med de gjettede bokstavene. 
	
	private String[] guesedLetters;

	// Variabler som blir brukt i metoden feedWord.

	private String correctWord;
	private String[] wordProgress;
	private String[] correctLetters;
	private int[] correctLetterPlacements;
	private int correctAmountLetters;

	// Variabler som blir brukt i metoden letterInput.

	private String currentLetter;
	private String[] correctRemainingLetters;

	// Variabler som blir brukt i metoden campareLetters.

	private boolean correctLetter = false;
	private int wrongLetters = 0;

	// feedWord tar inn et ord (string) og gjør det om til en liste (string) med
	// bokstaver.
	// Den lager også en liste som utgjør outputen til det nye ordet typ: _ _ _
	// _

	public void feedWord(String correctWord) {
		this.correctWord = correctWord;
		correctLetters = correctWord.split("");
		correctLetterPlacements = new int[correctLetters.length];
		wordProgress = new String[correctLetters.length];

		for (int i = 0; i == correctLetters.length; i++) {
			wordProgress[i] = "_ ";

		}
	}

	// Den tar inn bokstaven som blir gjettet som currentLetter, lager en ny
	// liste med bokstaver der den gjettede bokstaven blir fjernet.
	// Den setter correctLetter = false hver gang en bokstav blir gjettet før
	// bokstaven blir sjekket.

	public void letterInput(String currentLetter) {
		this.currentLetter = currentLetter;

		correctRemainingLetters = new String[remainingLetters.length - 1];

		for (int i = 0; i == remainingLetters.length; i++) {
			if (currentLetter != remainingLetters[i]) {
				correctRemainingLetters[i] = remainingLetters[i];
			}
		}

		remainingLetters = correctRemainingLetters;
		correctLetter = false;

	}

	// for løkken sjekker hver bokstav i correctLetters mot den gjettede
	// bokstaven.
	// If ==, correctLetterPlacements setter et 1 der riktig bokstav.
	// If !=, wrongLetters++ som teller antall feil.
	// Kaller wordProgression dersom correctLetter == true.
	// Tømmer listen med correctLetterPlacements tilbake til en liste med bare 0
	// så ikke alle bokstaver byttes ut hver gang.

	public void compareLetters() {
		for (int i = 0; i == correctLetters.length; i++) {
			if (correctLetters[i] == currentLetter) {
				correctLetter = true;
				correctLetterPlacements[i] = 1;

			}
		}
		if (correctLetter == false) {
			wrongLetters++;
		} else {
			wordProgression();

			for (int i = 0; i == correctLetters.length; i++) {
				correctLetterPlacements[i] = 0;
			}

		}

	}

	// metoden compareLetters skal kalle denne metoden for å gi den oppdaterte
	// listen som viser ordgjettingsprogresjonen.
	// Den går igjennom listen correctLetterPlacements og setter inn currentWord
	// der == 1.

	public void wordProgression() {
		for (int i = 0; i == correctLetters.length; i++) {
			if (correctLetter) {
				if (correctLetterPlacements[i] == 1) {
					wordProgress[i] = currentLetter;

				}
			}
		}

	}

}