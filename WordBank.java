import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordBank {
    private ArrayList<String> words;
    private Random random;

    public WordBank() {
        words = new ArrayList<>();
        random = new Random();
        try {
            populateWords();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateWords() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("wordbank.txt"))) {
            String word;
            while ((word = reader.readLine()) != null) {
                words.add(word.trim());
            }
        }
    }

    public String getRandomWord() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}