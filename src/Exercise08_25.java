/*
 * Kyle Schang
 * EECS 1510
 * 23-07-23
 */

import java.util.Scanner;

public class Exercise08_25 {

  public static void main(String[] args) {

    // initiating the matrix
    double[][] matrix = new double[3][3];

    // scanning in the matrix
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter a 3-by-3 matrix row by row:");
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        matrix[i][j] = scnr.nextDouble();
      }
    }

    if (isMarkovMatrix(matrix)) {
      System.out.println("It is a Markov matrix");
    } else {
      System.out.println("It is not a Markov matrix");
    }
  }

  public static boolean isMarkovMatrix(double[][] m) {

    boolean bol = true;

    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        if (m[i][j] < 0) {
          return false;
        }
      }
    }

    for (int i = 0; i < 3; ++i) {
      double sum = 0;
      for (int j = 0; j < 3; ++j) {
        sum = sum + m[j][i];
      }
      if (sum != 1) {
        return false;
      }
    }

    return true;
  }
}
