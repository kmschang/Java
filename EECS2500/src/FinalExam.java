import java.io.*;
import java.util.*;

public class FinalExam {

  public static int computePowerOf2(int N) {
    if (N == 0) {
      return 1;
    } else {
      return 2 * computePowerOf2(N - 1);
    }
  }

  public static void main(String[] args) {
    int exponent = 5; // Change this to the desired value of N
    int result = computePowerOf2(exponent);
    System.out.println("2^" + exponent + " = " + result);
  }
}
