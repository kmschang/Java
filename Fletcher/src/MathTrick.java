import java.util.HashMap;

public class MathTrick {

  HashMap<Character, Character> replaceKey = new HashMap<Character, Character>();

  private void updateReplaceKey() {
    replaceKey.put('0', 'Y');
    replaceKey.put('1', 'M');
    replaceKey.put('2', 'P');
    replaceKey.put('3', 'L');
    replaceKey.put('4', 'R');
    replaceKey.put('5', 'O');
    replaceKey.put('6', 'F');
    replaceKey.put('7', 'A');
    replaceKey.put('8', 'I');
    replaceKey.put('9', 'B');
  }

  private String num;
  private String reverseNum;
  private String subtractedNum;
  private String reverseSubtractedNum;
  private String addNum;
  private String millionNum;
  private String minusNum;
  private String replacedString;
  private String reversedString;

  private void setNum() {
    int first = (int)(Math.random() * 10);
    int second = (int)(Math.random() * 10);
    int third = (int)(Math.random() * 10);
    while ((first - third) < 2 && (first - third) > -2) {
      third = (int)(Math.random() * 10);
    }
    num = "" + first + second + third;
  }

  private void reverseNum() {
    StringBuilder reverse = new StringBuilder();
    for (int count = num.length() - 1; count >= 0; --count) {
      reverse.append(num.charAt(count));
    }
    reverseNum = reverse.toString();
  }

  private void subtractNum() {
    int num1 = Integer.parseInt(num);
    int num2 = Integer.parseInt(reverseNum);
    if (num1 > num2) {
      subtractedNum = "" + (num1 - num2);
    } else {
      subtractedNum = "" + (num2 - num1);
    }
  }

  private void reverseSubtractedNum() {
    StringBuilder reverse = new StringBuilder();
    for (int count = subtractedNum.length() - 1; count >= 0; --count) {
      reverse.append(subtractedNum.charAt(count));
    }
    reverseSubtractedNum = reverse.toString();
  }

  private void otherCalculations() {
    addNum = "" + (Integer.parseInt(subtractedNum) + Integer.parseInt(reverseSubtractedNum));
    millionNum = "" + (Integer.parseInt(addNum) * 1000000);
    minusNum = "" + (Integer.parseInt(millionNum) - 733361573);
  }

  private void replace() {
    updateReplaceKey();
    StringBuilder replaced = new StringBuilder();
    for (int count = 0; count < minusNum.length(); ++count) {
      replaced.append(replaceKey.get(minusNum.charAt(count)));
    }
    replacedString = replaced.toString();
  }

  private void reverseString() {
    StringBuilder reverse = new StringBuilder();
    for (int count = replacedString.length() - 1; count >= 0; --count) {
      reverse.append(replacedString.charAt(count));
    }
    reversedString = reverse.toString();
  }

  private void allCalculations() {
    setNum();
    reverseNum();
    subtractNum();
    reverseSubtractedNum();
    otherCalculations();
    replace();
    reverseString();
  }

  private void printAll() {
    System.out.println("The starting number: " + num);
    System.out.println("The reversed number: " + reverseNum);
    System.out.println("The difference is: " + subtractedNum);
    System.out.println("The reversed number added to difference: " + addNum);
    System.out.println("Number x one million: " + millionNum);
    System.out.println("Number subtracted and converted to string: " + minusNum);
    System.out.println("Replaced string: " + replacedString);
    System.out.println("Reversed string: " + reversedString);
  }

  public static void main(String[] args) {
    MathTrick MathTrick = new MathTrick();

    MathTrick.allCalculations();
    MathTrick.printAll();
  }
}
