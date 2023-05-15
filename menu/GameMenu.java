package menu;

import java.awt.*;
import javax.swing.*;

import gameController.GameController;
import listeners.KeyboardListener;

/**
 * The GameMenu class represents the game screen menu.
 */
public class GameMenu extends JFrame
{	
	char[] currentWordArray;
	char[] displayedWordArray;
	int failCounter = 1;
	String currentWord = "";

	String whichHangmanPath = "/assets/img/hangman" + failCounter + ".png";
	
	JPanel entireGameBoard;
	JLabel wordToGuess;
	JLabel hangmanHolder;
	JButton[] buttons = new JButton[26];
	
	/**
 	* Constructs a GameMenu object.
 	* 
 	* The constructor initializes the game menu by performing the following tasks:
 	* - Generates a random word using the GameController's generateWord() method.
 	* - Sets up the window properties (size, visibility, title, etc.).
 	* - Creates and configures various JPanels to organize the game elements.
 	* - Initializes the hangman image with the first stage.
 	* - Creates an array of underscores representing the displayed word.
 	* - Sets up the keyboard layout by adding buttons to the respective rows.
 	* - Adds the game components (hangman image, displayed word, keyboard) to the game board panel.
 	* - Sets up a KeyboardListener to handle button actions.
 	*/
	public GameMenu()
	{
		// generate a random word
		try {
			currentWord = GameController.generateWord();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			String message = "Error while reading words.txt";
			new GameOverMenu(message);
			GameMenu.super.dispose();
		}

		// fill buttons array
		char buttonChar = 'A';
		for (int i = 0; i < 26; i++) {
		    JButton button = new JButton(String.valueOf(buttonChar));
		    button.setName("but" + buttonChar);
		    buttons[i] = button;
		    buttonChar++;
		}

		// window settings
		this.setVisible(true);
		this.setSize(500,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Hangman");
		
		Font fontForGuess = new Font("Helvetica", Font.PLAIN, 30);
		String currentWord = this.currentWord;
		
		// JPanels creation
		entireGameBoard = new JPanel();
		JPanel keyboardHolder = new JPanel();
		JPanel gridForRows = new JPanel();
		JPanel topRow  = new JPanel();
		JPanel medRow = new JPanel();
		JPanel bottomRow = new JPanel();
		
		hangmanHolder = new JLabel();
		wordToGuess = new JLabel();
		
		// initialize first image of the game
		hangmanHolder.setIcon
		(
			new ImageIcon(getClass().getResource("/assets/img/hangman1.png"))
		);
			
		// JPanels settings
		gridForRows.setLayout(new GridLayout(3, 0, 3, 3));
		topRow.setLayout(new FlowLayout());
		medRow.setLayout(new FlowLayout());
		bottomRow.setLayout(new FlowLayout());
		entireGameBoard.setLayout(new FlowLayout());
				
		// creating an array of underscores
		displayedWordArray = GameController.wordToUnderscores(currentWord);
		
		String wordToDisplay = new String(displayedWordArray);
		
		wordToGuess.setText(wordToDisplay);
		wordToGuess.setFont(fontForGuess);                             
		
		// keyboard creation
		topRow.add(buttons[0]);
		topRow.add(buttons[25]);
		topRow.add(buttons[4]);
		topRow.add(buttons[17]);
		topRow.add(buttons[19]);
		topRow.add(buttons[24]);
		topRow.add(buttons[20]);
		topRow.add(buttons[8]);
		topRow.add(buttons[14]);
		topRow.add(buttons[15]);

		medRow.add(buttons[16]);
		medRow.add(buttons[18]);
		medRow.add(buttons[3]);
		medRow.add(buttons[5]);
		medRow.add(buttons[6]);
		medRow.add(buttons[7]);
		medRow.add(buttons[9]);
		medRow.add(buttons[10]);
		medRow.add(buttons[11]);
		medRow.add(buttons[12]);

		bottomRow.add(buttons[22]);
		bottomRow.add(buttons[23]);
		bottomRow.add(buttons[2]);
		bottomRow.add(buttons[21]);
		bottomRow.add(buttons[1]);
		bottomRow.add(buttons[13]);
		
		gridForRows.add(topRow);
		gridForRows.add(medRow);
		gridForRows.add(bottomRow);
		keyboardHolder.add(gridForRows);
		entireGameBoard.add(hangmanHolder);
		entireGameBoard.add(wordToGuess);
		entireGameBoard.add(keyboardHolder);
		
		this.add(entireGameBoard);
		
		//setting up Listener
		KeyboardListener keyboardListener = new KeyboardListener(this, wordToGuess, buttons);

		for (JButton button : buttons) {
			button.addActionListener(keyboardListener);
		}
			
	}

	/**
	 * currentWord getter
	 * @return currentWord
	 */
	public String getCurrentWord() {
		return currentWord;
	}

	/**
	 * displayedWordArray getter
	 * @return displayedWordArray
	 */
	public char[] getDisplayedWordArray() {
		return displayedWordArray;
	}

	/**
	 * Increments the fail counter
	 */
	public void incrementFailCounter() {
		failCounter += 1;
	}

	/**
	 * failCounter getter
	 * @return failCounter
	 */
	public int getFailCounter() {
		return failCounter;
	}

	/**
	 * hangmanHolder getter
	 * @return hangmanHolder
	 */
	public JLabel getHangmanHolder() {
		return hangmanHolder;
	}
}