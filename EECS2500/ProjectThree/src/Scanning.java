import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Scanning {

    Scanner scanner;
    {
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("src/pg64317.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String formatting(String word) {
        word = word.toLowerCase();
        word = word.replaceAll("\\s+", "");
        word = word.replaceAll("[^([a-zA-Z’])]", "");

        if (!word.isEmpty()) {

            boolean firstLetter = Character.isAlphabetic(word.charAt(0));
            boolean lastLetter = Character.isAlphabetic(word.charAt(word.length() - 1));

            if (!firstLetter) {
                word = word.substring(1);
            } else if (!lastLetter) {
                word = word.substring(0, word.length() - 1);
            } else if (!firstLetter && !lastLetter) {
                word = word.substring(1, word.length() - 1);
            }
        }

        return word;
    }

    public static void main(String[] args) {

        Scanning Scanning = new Scanning();

        while (Scanning.scanner.hasNext()) {
            String word = Scanning.scanner.next();
            word = Scanning.formatting(word);
            System.out.println(word);
        }

    }
}
