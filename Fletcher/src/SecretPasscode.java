import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SecretPasscode {

  private final String[] characters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "k",  "l", "M", "N", "O", "P",
                                       "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a,", "b", "c", "d", "e", "f",
                                       "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",  "r", "s", "t", "u", "v",
                                       "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7",  "8", "9", "0"};

  private final Scanner scnr = new Scanner(System.in);

  private int length;
  private boolean repeat = true;
  private final ArrayList<String> passcodes = new ArrayList<>();

  private void setLength() {
    System.out.print("Enter a password Length (6 or more): ");
    try {
      length = scnr.nextInt();
      if (length < 6) {
        System.out.println("    Password must be at least 6 characters long.");
        setLength();
      }
    } catch (Exception e) {
      System.out.println("    That was not a number. Please try again.");
      scnr.next();
      setLength();
    }
  }

  private void setPasscode() {
    int counter = 0;
    StringBuilder currentPasscode = new StringBuilder();
    while (counter < length) {
      int random = (int)(Math.random() * 62);
      currentPasscode.append(characters[random]);
      ++counter;
    }
    passcodes.add(currentPasscode.toString());
    System.out.println();
    System.out.println("A password has been written to the text file");
  }

  private void setRepeat() {
    System.out.print("Would you like to generate another password? Y/N: ");
    String input = scnr.next();
    if (input.equalsIgnoreCase("y")) {
      repeat = true;
    } else if (input.equalsIgnoreCase("n")) {
      repeat = false;
    } else {
      System.out.println("    That was not an option. Please try Y/N.");
      setRepeat();
    }
  }

  private void saveToFile() {
    try {
      FileWriter fileWriter = new FileWriter("passcodes.txt");
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      for (int passcode = 0; passcode < passcodes.size(); ++passcode) {
        bufferedWriter.write((passcode + 1) + ".    " + passcodes.get(passcode));
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
    } catch (IOException e) {
      System.out.println("Error writing to file");
    }
  }

  private void startingMessage() {
    System.out.println("************************************");
    System.out.println("Welcome to a simple password generator.");
    System.out.println("The password will include lowercase, uppercase, & numbers.");
  }

  private void endingMessage() {
    System.out.println("Thank you for using the Pass Code Generator.");
    System.out.println();
    allPasscodes();
  }

  private void allPasscodes() {
    int numPasscodes = passcodes.size();
    System.out.println("Here are your randomly generated codes:");
    for (int passcode = 0; passcode < numPasscodes; ++passcode) {
      System.out.println("    " + (passcode + 1) + ".    " + passcodes.get(passcode));
    }
  }

  public static void main(String[] args) {
    SecretPasscode SecretPasscode = new SecretPasscode();

    SecretPasscode.startingMessage();
    while (SecretPasscode.repeat) {
      SecretPasscode.setLength();
      SecretPasscode.setPasscode();
      SecretPasscode.setRepeat();
    }
    SecretPasscode.saveToFile();
    SecretPasscode.endingMessage();
  }
}
