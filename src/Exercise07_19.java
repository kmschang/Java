/*
 * Kyle Schang
 * EECS 1510
 * 02-02-23
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise07_19 {

  public static void main(String[] args) {

    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter List: ");

    int num = scnr.nextInt();

    int[] numbers = new int[num];
    // number of different integers

    for (int k = 0; k < num; ++k) {
      numbers[k] = scnr.nextInt();
    }

    if (!isSorted(numbers)) {
      System.out.println("The list is not sorted");
    } else {
      System.out.println("The list is already sorted");
    }
  }

  public static boolean isSorted(int[] list) {

    int[] sorted_numbers = new int[list.length];
    System.arraycopy(list, 0, sorted_numbers, 0, list.length);
    Arrays.sort(sorted_numbers);

    for (int j = 0; j < sorted_numbers.length; ++j) {
      if (list[j] != sorted_numbers[j]) {
        return false;
      }
    }
    return true;
  }
}

// format this file
