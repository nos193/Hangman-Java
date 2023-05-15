package gameController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import fileManager.FileManager;

/**
 * The GameController class provides methods for managing the game logic.
 * It includes functionality for generating a random word, checking user guesses,
 * and converting words to underscores.
 */
public class GameController 
{
	static ArrayList<String> wordBank = new ArrayList<String>();
	
	/**
     * Checks the current word for matches with the specified character.
     *
     * @param currentWord the word to check for matches
     * @param charToTest the character to test against the word
     * @return a boolean array indicating which positions in the word match the character
     */
	public static boolean[] checkArrayForMatches(String currentWord, char charToTest)
	{
        System.out.println("input: "+charToTest);
		String upperCaseCurrentWord = currentWord.toUpperCase();
		char[] currentWordArray = upperCaseCurrentWord.toCharArray();
		boolean[] returnArray = new boolean[currentWordArray.length];
		
		for(int x = 0; x < returnArray.length; x++)
		{
			char characterInArray = currentWordArray[x];
			if(characterInArray == charToTest)
			{
				returnArray[x] = true;
			}
			else 
			{
				returnArray[x] = false;
			}		
		}
 		return returnArray;
	}
	
	/**
     * Checks if the boolean array contains at least one 'true' value.
     *
     * @param someBoolArray the boolean array to check
     * @return true if the array contains 'true', false otherwise
     */
	public static boolean doesArrayContainATrue(boolean[] someBoolArray)
	{
		for (boolean x : someBoolArray)
		{
			if(x == true) 
			{
				return true;
			}
		}
		return false;
	}
	
	/**
     * Checks if the character array contains underscores.
     *
     * @param someCharArray the character array to check
     * @return true if the array contains underscores, false otherwise
     */
	public static boolean doesArrayContainUnderscores(char[] someCharArray)
	{
		for(char x : someCharArray)
		{
			if(x == '_')
			{
				return true;
			}	
		}
		return false;
	}

	/**
     * Generates a random word from the word bank.
     *
     * @return a randomly selected word
     * @throws IOException if there is an error reading the wordbank.txt file
     */
    public static String generateWord() throws IOException {
        String[] words = FileManager.readLinesFromFile("assets/words/wordbank.txt");
    
        Random random = new Random();
        int index = random.nextInt(words.length);

		System.out.println("The secret word is: " + words[index]);
        return words[index];
    }

	/**
     * Converts a word into an array of underscores, with spaces preserved.
     *
     * @param word the word to convert
     * @return an array of underscores representing the word
     */
	public static char[] wordToUnderscores(String word) {
		char[] wordArray = word.toCharArray();
		for(int x = 0; x < wordArray.length; x++)
		{
			if(wordArray[x] != ' ')
			{
				wordArray[x] = '_';
			}
		}
		return wordArray;
	}
}