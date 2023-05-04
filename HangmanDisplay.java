public class HangmanDisplay {
    public static final String[] HANGMAN_PICS = {
            "   +----+\n   |    |\n        |\n        |\n        |\n        |\n=========",
            "   +----+\n   |    |\n   O    |\n        |\n        |\n        |\n=========",
            "   +----+\n   |    |\n   O    |\n   |    |\n        |\n        |\n=========",
            "   +----+\n   |    |\n   O    |\n  /|    |\n        |\n        |\n=========",
            "   +----+\n   |    |\n   O    |\n  /|\\   |\n        |\n        |\n=========",
            "   +----+\n   |    |\n   O    |\n  /|\\   |\n  /     |\n        |\n=========",
            "   +----+\n   |    |\n   O    |\n  /|\\   |\n  / \\   |\n        |\n========="
    };

    public void printHangman(int lives) {
        System.out.println(HANGMAN_PICS[HANGMAN_PICS.length - lives - 1]);
    }
}
