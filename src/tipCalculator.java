import java.util.InputMismatchException;
import java.util.Scanner;

public class tipCalculator {

  protected int numberOfPeople;
  protected double totalPrice;
  protected double tipPercentage;
  protected double tipTotal;
  protected double totalPerPerson;
  protected boolean round;

  public Scanner scnr = new Scanner(System.in);

  public void setNumberOfPeople() {
    System.out.println("How many people are in your party?");
    numberOfPeople = scnr.nextInt();
  }

  public void setTotalPrice() {
    System.out.println("What was the final cost of the meal?");
    totalPrice = scnr.nextDouble();
  }

  public void setTipPercentage() {
    System.out.println("What percentage of tip did you want to leave?");
    tipPercentage = scnr.nextDouble();
  }

  public void setRound() {
    boolean correctAnswer = false;
    do {
      System.out.println("Did you want to round to the nearest dollar?");
      String input = scnr.nextLine();
      if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
        round = true;
        correctAnswer = true;
      } else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
        round = false;
        correctAnswer = true;
      } else {
        System.out.println("That is an invalid input. Please only input 'yes' or 'y' or 'no' or 'n'. Thanks.");
      }
    } while (!correctAnswer);
  }

  public static void main(String[] args) {
    tipCalculator tipCalculator = new tipCalculator();
    tipCalculator.setRound();
  }
}

class checkNumberInputs {

  public Scanner scnr = new Scanner(System.in);

  public int checkIntInput(String prompt) {
    do {
      try {
        System.out.println(prompt);
        return Integer.parseInt(scnr.nextLine());
      } catch (NumberFormatException exception) {
        System.out.println("Invalid input. Please only input integers.");
      }
    } while (true);
  }

  public int checkIntInputRange(String prompt, int lower, int upper) {
    boolean validAnswer = false;
    int input;
    do {
      try {
        System.out.println(prompt);
        input = Integer.parseInt(scnr.nextLine());
        if (input >= lower & input <= upper) {
          return input;
        } else {
          System.out.println("Input out of bounds. Please enter an integer between " + lower + " and " + upper + ".");
        }
      } catch (NumberFormatException exception) {
        System.out.println("Invalid input. Please only input integers.");
      }
    } while (true);
  }

  public double checkDoubleInput(String prompt) {
    do {
      try {
        System.out.println(prompt);
        return Double.parseDouble(scnr.nextLine());
      } catch (NumberFormatException exception) {
        System.out.println("Invalid input. Please only input integers or doubles.");
      }
    } while (true);
  }

  public double checkDoubleInputRange(String prompt, double lower, double upper) {
    boolean validAnswer = false;
    double input;
    do {
      try {
        System.out.println(prompt);
        input = Double.parseDouble(scnr.nextLine());
        if (input >= lower & input <= upper) {
          return input;
        } else {
          System.out.println("Input out of bounds. Please enter an integer or double between " + lower + " and " +
                             upper + ".");
        }
      } catch (NumberFormatException exception) {
        System.out.println("Invalid input. Please only input integers or doubles.");
      }
    } while (true);
  }
}

class checkStringInputs {

  public Scanner scnr = new Scanner(System.in);

  public boolean checkStringInputYorN(String prompt) {
    do {
      System.out.println(prompt + " (yes or no)");
      String input = scnr.nextLine();
      if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
        return true;
      } else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
        return false;
      } else {
        System.out.println(input + " is not a valid answer. Please input 'yes' or 'no'");
      }
    } while (true);
  }

  public static void main(String[] args) { checkStringInputs checkStringInputs = new checkStringInputs(); }
}
