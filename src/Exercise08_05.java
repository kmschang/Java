/*
 * Kyle Schang
 * EECS 1510
 * 23-07-23
 */

import java.util.*;

public class Exercise08_05 {

  public static void main(String[] args) {

    Scanner scnr = new Scanner(System.in);

    // initialing the variables
    double[][] matrix1 = new double[3][3];
    double[][] matrix2 = new double[3][3];
    double[][] answer = new double[3][3];

    // scanning matrix 1 in
    System.out.println("Enter matrix 1");
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        matrix1[i][j] = scnr.nextDouble();
      }
    }

    // Scanning matrix 2 in
    System.out.println("Enter matrix 2");
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        matrix2[i][j] = scnr.nextDouble();
      }
    }

    // adding them together
    if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
      System.out.println("FAIL");
    } else {
      for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
          answer[i][j] = matrix1[i][j] + matrix2[i][j];
        }
      }
    }

    // printing the answer
    for (int i = 0; i < answer.length; i++) {
      for (int j = 0; j < answer[0].length; j++) {

        System.out.print(matrix1[i][j] + " ");
        if (i == 1 && j == 2) {
          System.out.print(" + ");
        } else {
          System.out.print("   ");
        }
      }
      for (int j = 0; j < answer[0].length; j++) {
        System.out.print(matrix2[i][j] + " ");
        if (i == 1 && j == 2) {
          System.out.print(" = ");
        } else {
          System.out.print("   ");
        }
      }
      for (int j = 0; j < answer[0].length; j++) {
        System.out.print(answer[i][j] + " ");
      }
      System.out.println();
    }
  }
}
