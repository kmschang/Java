/*
 * Kyle Schang
 * EECS 1510
 * 02-02-23
 */

import java.util.Arrays;
import java.util.Scanner;

public class Exercise07_03 {

  public static void main(String[] args) {

    Scanner scnr = new Scanner(System.in);

    System.out.println("Enter the integer between 1 and 100: ");

    int[] numbers = new int[100];
    // number of different integers
    int i = 0;

    while (true) {
      int number = scnr.nextInt();
      if (number == 0) {
        break;
      }
      numbers[i] = number;
      ++i;
    }

    int[] new_numbers = new int[i];
    System.arraycopy(numbers, 0, new_numbers, 0, i);

    Arrays.sort(new_numbers);

    // System.out.println(Arrays.toString(new_numbers));

    int times = 1;
    for (int k = 0; k < new_numbers.length; ++k) {
      if (k == new_numbers.length - 1 & new_numbers[new_numbers.length - 1] == new_numbers[new_numbers.length - 2]) {
        ++times;
      } else if (k == new_numbers.length - 1) {
        System.out.println(new_numbers[k] + " occurs 1 time");
        break;
      } else if (new_numbers[k] == new_numbers[k + 1]) {
        ++times;
      } else {
        if (times == 1) {
          System.out.println(new_numbers[k] + " occurs 1 time");
          times = 1;
        } else {
          System.out.println(new_numbers[k] + " occurs " + times + " times");
          times = 1;
        }
      }
    }

    scnr.close();
  }
}
