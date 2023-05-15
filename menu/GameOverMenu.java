package menu;

import javax.swing.*;

import listeners.GameOverButtonListener;

import java.awt.*;

/**
 * The GameOverMenu class extends JFrame and represents the game over menu screen.
 * It displays a message indicating the game outcome and provides a "Play Again" button.
 */
public class GameOverMenu extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton gameOverButton;
    private GridBagConstraints gbc = new GridBagConstraints();

    /**
     * Constructs a GameOverMenu object with the specified game over statement.
     *
     * @param message the statement to display on the game over menu
     */
    public GameOverMenu(String message) {
        this.setSize(800, 150);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hangman");
        this.validate();

        JPanel gameOverPanel = new JPanel();
        JLabel messageToSay = new JLabel();
        gameOverButton = new JButton("Play Again");

        Font gameOverFont = new Font("Helvetica", Font.PLAIN, 30);

        gameOverPanel.setLayout(new GridBagLayout());
        messageToSay.setText(message);
        messageToSay.setFont(gameOverFont);

        GameOverButtonListener someButtonListener = new GameOverButtonListener(this);
        gameOverButton.addActionListener(someButtonListener);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gameOverPanel.add(messageToSay, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gameOverPanel.add(gameOverButton, gbc);

        this.add(gameOverPanel);
    }
}
