import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// This program reads in a text file and prints the number of words in the file and the words and their frequencies in
// order of frequency
public class projectThree {

  // Scanner to read in the text file
  Scanner scanner;
  {
    try {
      scanner = new Scanner(new BufferedReader(new FileReader("src/pg64317.txt")));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  // Map to store the words and their frequencies
  Map<String, Integer> wordMap = new HashMap<>();

  public static void main(String[] args) {
    projectThree projectThree = new projectThree();

    projectThree.readText();
  }

  // Reads each word in
  public void readText() {
    while (scanner.hasNext()) {
      String word = scanner.next();

      // Formats the word
      word = formatting(word);

      // Checks if the word is in the map
      if (checkWord(word)) {
        // If the word is in the map, increment the frequency
        wordMap.put(word, wordMap.get(word) + 1);
      } else {
        // If the word is not in the map, add it to the map with a frequency of 1
        wordMap.put(word, 1);
      }
    }

    printMap();
  }

  // Converts each word to lower case
  public String lowerCase(String word) { return word.toLowerCase(); }

  // Removes punctuation
  public String removePunctuation(String word) { return word.replaceAll("[^a-zA-Z]", ""); }

  // Formats the word to remove punctuation and convert to lower case all in one
  public String formatting(String word) { return removePunctuation(lowerCase(word)); }

  // Checks if the word is in the map
  public boolean checkWord(String word) { return wordMap.containsKey(word); }

  // Prints the map
  public void printMap() {

    // Prints number of words in the file
    System.out.println("Number of total words: " + wordMap.values().stream().mapToInt(Integer::intValue).sum());

    // Prints the number of words in the map
    System.out.println("Number of unique words: " + wordMap.size());

    // Prints the words and their frequencies in order of frequency
    wordMap.entrySet()
        .stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEach(System.out::println);
  }
}
