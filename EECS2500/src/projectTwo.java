import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class projectTwo {

  // Scanner to input data
  Scanner scnr = new Scanner(System.in);

  // Queue and Linked List
  LinkedQueueImplementation<Object> queue = new LinkedQueueImplementation<>();

  // Rules
  Map<Character, String> ruleDictionary = new HashMap<>();

  // Variables
  public double angle;
  public String startingPattern;
  public int numRules;
  public int numIterations;

  // Function to scan inputs
  void scanInputs() {
    angle = scnr.nextDouble();
    scnr.nextLine();
    startingPattern = scnr.nextLine();
    numRules = scnr.nextInt();
    scnr.nextLine();
    for (int i = 0; i < numRules; i++) {
      scanRules();
    }
    numIterations = scnr.nextInt();
  }

  // Scans in the rules and places them in the dictionary/map for later
  void scanRules() {
    String line = scnr.nextLine();
    String[] ruleParts = line.split(" ");
    char firstLetter = ruleParts[0].charAt(0);
    String restOfLine = line.substring(2);
    ruleDictionary.put(firstLetter, restOfLine);
  }

  // Initializes the queue with the input pattern
  void initiateQueue() {
    String[] splitArray = startingPattern.split(" ");
    for (int i = 0; i < splitArray.length; i++) {
      queue.enqueue(splitArray[i]);
    }
    queue.enqueue("1");
  }

  // Function to expand the rules
  void expand() throws QueueUnderflowException {
    for (int i = 0; i < numIterations; i++) {
      int queueSize = queue.size();
      for (int j = 0; j < queueSize; j++) {
        String currentSymbol = (String)queue.dequeue();
        String[] currentSymbols = currentSymbol.split(" ");
        for (String symbolPart : currentSymbols) {
          Character currentCharacter = symbolPart.charAt(0);

          if (currentCharacter == '1') {
            queue.enqueue("1");
          } else if (ruleDictionary.containsKey(currentCharacter)) {
            String rule = ruleDictionary.get(currentCharacter);
            queue.enqueue(rule + " ");
          } else {
            queue.enqueue(symbolPart + " ");
          }
        }
      }
    }
  }

  void printOutput() throws QueueUnderflowException {
    while (!queue.isEmpty()) {
      String output = (String)queue.dequeue();
      if (output != "1") {
        System.out.print(output);
      }
    }
  }

  // Function to run the program
  void run() throws QueueUnderflowException {
    scanInputs();
    initiateQueue();
    expand();
    printOutput();
  }

  // Main Function
  public static void main(String[] args) throws QueueUnderflowException {
    projectTwo PJ2 = new projectTwo();
    PJ2.run();
  }
}
