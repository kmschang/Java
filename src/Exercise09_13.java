import java.util.*;

public class Exercise09_13 {

  public static int row = 0;
  public static int column = 0;
  public static double[][] maxValue = {{0, 0}};

  public static double[][] locateLargest(double[][] a) {

    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < a[i].length; ++j) {
        if (a[i][j] > a[row][column]) {
          maxValue[0][0] = row;
          row = i;
          maxValue[0][1] = column;
          column = j;
        }
      }
    }

    return maxValue;
  }

  public static void main(String[] args) {

    Scanner scnr = new Scanner(System.in);

    System.out.println("Enter the number of rows and columns in the array: ");
    int row = scnr.nextInt();
    int column = scnr.nextInt();

    double[][] numbers = new double[row][column];

    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < column; ++j) {
        numbers[i][j] = scnr.nextDouble();
      }
    }

    Exercise09_13 array1 = new Exercise09_13();

    locateLargest(numbers);

    System.out.println("The largest element is " + numbers[Exercise09_13.row][Exercise09_13.column] + ", located at (" +
                       Exercise09_13.row + ", " + Exercise09_13.column + ")");
  }
}
