import java.util.*;
import java.io.*;


public class ProjectThreeTwo {

    public Map<Integer, LinkedQueueImplementation<String>> wordMap = new HashMap<>();

    // Scanner to input data from text file
    Scanner scanner;
    {
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("src/pg64317.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Function to format the word and remove punctuation
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

    public void readText() {
        while (scanner.hasNext()) {
            String word = scanner.next();
            word = formatting(word);

            int hashValue = word.hashCode();
            int hashLocation = Math.abs(hashValue % 1091);

            if (wordMap.containsKey(hashLocation)) {
                LinkedQueueImplementation<String> linkedQueue = wordMap.get(hashLocation);
                if (!linkedQueue.contains(word)) {
                    try {
                        linkedQueue.enqueue(word);
                    } catch (QueueOverflowException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                LinkedQueueImplementation<String> linkedQueue = new LinkedQueueImplementation<>();
                try {
                    linkedQueue.enqueue(word);
                } catch (QueueOverflowException e) {
                    throw new RuntimeException(e);
                }
                wordMap.put(hashLocation, linkedQueue);
            }
        }
    }

    public void printMap() {
        for (int index = 0; index < 1091; index++) {
            if (wordMap.containsKey(index)) {
                LinkedQueueImplementation<String> linkedQueue = wordMap.get(index);
                System.out.println("[" + index + "] = " + linkedQueue.size() + " items");
            }

        }
        // print sum of all linked lists
        int sum = 0;
        for (int index = 0; index < 1091; index++) {
            if (wordMap.containsKey(index)) {
                LinkedQueueImplementation<String> linkedQueue = wordMap.get(index);
                sum += linkedQueue.size();
            }
        }
        System.out.println("All Entries: " + sum);
        // print all words in linked list
        for (int index = 0; index < 1091; index++) {
            System.out.print("[" + index + "] = ");
            if (wordMap.containsKey(index)) {
                LinkedQueueImplementation<String> linkedQueue = wordMap.get(index);
                while (!linkedQueue.isEmpty()) {
                    try {
                        System.out.print(linkedQueue.dequeue() + " ");
                    } catch (QueueUnderflowException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.print("\n");
        }


    }

    public static void main(String[] args) {
        ProjectThreeTwo projectThree = new ProjectThreeTwo();

        projectThree.readText();
        projectThree.printMap();
    }
}
