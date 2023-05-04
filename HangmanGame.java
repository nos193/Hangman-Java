public class HangmanGame {
    private String word;
    private StringBuilder currentGuess;

    public HangmanGame(String word) {
        this.word = word;
        currentGuess = new StringBuilder("_".repeat(word.length()));
    }

    public boolean guessLetter(char letter) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                currentGuess.setCharAt(i, letter);
                found = true;
            }
        }
        return found;
    }

    public String getOriginalWord() {
        return word;
    }

    public boolean isComplete() {
        return !currentGuess.toString().contains("_");
    }

    public String getCurrentGuess() {
        return currentGuess.toString();
    }
}