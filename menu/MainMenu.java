package menu;

import java.awt.*;
import javax.swing.*;

import listeners.MainMenuButtonListener;

/**
 * This class is the entry point of the game, it displays the main menu
 */
public class MainMenu extends JFrame {
	private JButton playGameButton, exitButton;
	private JLabel mainLabel;

	/**
	 * MainMenu constructor, it initializes the swing window
	 */
	public MainMenu() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Main menu");
		this.setResizable(false);

		playGameButton = new JButton("Start");
		exitButton = new JButton("Exit");
		
		mainLabel = new JLabel();
		mainLabel.setIcon(new ImageIcon(getClass().getResource("/assets/img/hangman8.png")));

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(playGameButton);
		buttonsPanel.add(exitButton);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(mainLabel, BorderLayout.CENTER);
		mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

		this.add(mainPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		MainMenuButtonListener buttonListener = new MainMenuButtonListener(this);

		playGameButton.addActionListener(buttonListener);
		exitButton.addActionListener(buttonListener);
	}

	/**
	 * playGameButton getter
	 * @return playGameButton
	 */
	public JButton getPlayGameButton() {
		return playGameButton;
	}

	/**
	 * exitButton getter
	 * @return exitButton
	 */
	public JButton getExitButton() {
		return exitButton;
	}
}
