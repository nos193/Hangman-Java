package fileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The FileManager class provides utility methods for file handling operations.
 */
public class FileManager {

    /**
     * Reads all lines from a file and returns them as an array of strings.
     *
     * @param fileName the name of the file to read
     * @return an array of strings representing the lines in the file
     * @throws IOException if an I/O error occurs while reading the file
     */ 
    public static String[] readLinesFromFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        reader.close();
        return lines.toArray(new String[0]);
    }
}