import java.util.Scanner;

public class HangmanController {
    private HangmanDisplay display = new HangmanDisplay();

    public void startGame() {
        HangmanGame game = new HangmanGame((new WordBank()).getRandomWord());
        int lives = HangmanDisplay.HANGMAN_PICS.length - 1;
        Scanner scanner = new Scanner(System.in);

        while (lives > 0 && !game.isComplete()) {
            display.printHangman(lives);
            System.out.println("\nCurrent word: " + game.getCurrentGuess());
            System.out.println("Lives remaining: " + lives);
            System.out.print("Enter a letter: ");
            String input = scanner.next();
            char letter;

            if (input.length() > 1) {
                System.out.println("Please enter only one letter at a time.");
                continue;
            }

            letter = input.charAt(0);

            if (!Character.isLetter(letter)) {
                System.out.println("Please enter a valid letter.");
                continue;
            }

            if (!game.guessLetter(Character.toLowerCase(letter))) lives--;
            System.out.println();
        }

        display.printHangman(lives);
        System.out.println();
        System.out.println(game.isComplete() ? "Congratulations! You guessed the word: " + game.getCurrentGuess() : "Sorry, you ran out of lives. The word was: " + game.getOriginalWord());
        scanner.close();
    }
}