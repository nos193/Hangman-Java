package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menu.GameOverMenu;
import menu.MainMenu;

/**
 * The ActionListener implementation for the "Game Over" button in the Game Over menu.
 * It handles the button click event and performs the necessary actions.
 */
public class GameOverButtonListener implements ActionListener {
    private GameOverMenu gameOverMenu;

    /**
     * Constructs a GameOverButtonListener with the specified GameOverMenu.
     *
     * @param gameOverMenu the GameOverMenu instance associated with the button
     */
    public GameOverButtonListener(GameOverMenu gameOverMenu) {
        this.gameOverMenu = gameOverMenu;
    }

    /**
     * Performs the action in response to the button click event.
     * It creates a new instance of the MainMenu and disposes the GameOverMenu.
     *
     * @param e the ActionEvent representing the button click event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new MainMenu();
        gameOverMenu.dispose();
    }
}
