package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menu.GameMenu;
import menu.MainMenu;

/**
 * The MainMenuButtonListener class is responsible for handling button actions in the main menu.
 */
public class MainMenuButtonListener implements ActionListener {
	private MainMenu mainMenu;

	/**
     * Constructs a MainMenuButtonListener with the specified main menu.
     * @param mainMenu The main menu associated with the button actions.
     */
	public MainMenuButtonListener(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	/**
     * Invoked when a button is clicked.
     *
     * @param e The action event representing the button click.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainMenu.getPlayGameButton()) {
			new GameMenu();
			mainMenu.dispose();
		} else if (e.getSource() == mainMenu.getExitButton()) {
			System.exit(0);
		}
	}
}
