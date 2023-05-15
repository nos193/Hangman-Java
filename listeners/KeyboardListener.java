package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import gameController.GameController;
import menu.GameMenu;
import menu.GameOverMenu;

/**
 * The KeyboardListener class implements the ActionListener interface
 * to handle keyboard button events in the GameMenu.
 * It updates the game state based on the user's input and interacts
 * with the GameMenu, GameController, and GameOverMenu classes.
 */
public class KeyboardListener implements ActionListener {
	private GameMenu gameMenu;
	private JLabel wordToGuess;
	private JButton[] buttons;

    /**
     * Constructs a KeyboardListener object with the specified GameMenu,
     * JLabel, and JButton array.
     *
     * @param gameMenu the GameMenu object to interact with
     * @param wordToGuess the JLabel representing the word to guess
     * @param buttons the array of JButtons representing the keyboard buttons
     */
	public KeyboardListener(GameMenu gameMenu, JLabel wordToGuess, JButton[] buttons) {
		this.gameMenu = gameMenu;
		this.wordToGuess = wordToGuess;
		this.buttons = buttons;
	}

    /**
     * Handles the actionPerformed event for keyboard buttons.
     * Updates the game state based on the user's input and interacts
     * with the GameMenu, GameController, and GameOverMenu classes.
     *
     * @param e the ActionEvent representing the button click
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		String stringToConvert = ((JButton) e.getSource()).getText();
		char charToSend = stringToConvert.charAt(0);

		boolean[] isArrayRight = GameController.checkArrayForMatches(gameMenu.getCurrentWord(), charToSend);

		String upperCaseCurrentWord = gameMenu.getCurrentWord().toUpperCase();
		char[] currentWordArray = upperCaseCurrentWord.toCharArray();

		for (int x = 0; x < isArrayRight.length; x++) {
			if (isArrayRight[x]) {
				gameMenu.getDisplayedWordArray()[x] = currentWordArray[x];
			}
		}

		String wordToShow = new String(gameMenu.getDisplayedWordArray());
		wordToGuess.setText(wordToShow);

		if (GameController.doesArrayContainATrue(isArrayRight)) {
			if (!GameController.doesArrayContainUnderscores(gameMenu.getDisplayedWordArray())) {
				String winPhrase = "You Won! The word was \'" + gameMenu.getCurrentWord() + "\'.";
				new GameOverMenu(winPhrase);

				gameMenu.dispose();
			}
		} else {
			gameMenu.incrementFailCounter();
			String whichHangmanPath = "/assets/img/hangman" + gameMenu.getFailCounter() + ".png";
			if (gameMenu.getFailCounter() == 8) {
				String losePhrase = "You Lost! The word was \'" + gameMenu.getCurrentWord() + "\'.";
				new GameOverMenu(losePhrase);
				gameMenu.dispose();
			}

			gameMenu.getHangmanHolder().setIcon(new ImageIcon(getClass().getResource(whichHangmanPath)));
		}

		String holderForButton = ((JButton) e.getSource()).getText();
		String buttonCalled = "but" + holderForButton;
		for (JButton button : buttons) {
			if (button.getName().equals(buttonCalled)) {
				button.setEnabled(false);
				break;
			}
		}
	}
}
