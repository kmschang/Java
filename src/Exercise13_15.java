import java.math.*;
import java.util.Scanner;

public class Exercise13_15 {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    System.out.print("Enter rational number 1 with numerator and denominator separated by a space: ");
    String numerator1 = scnr.next();
    String denominator1 = scnr.next();

    System.out.print("Enter rational number 2 with numerator and denominator separated by a space: ");
    String numerator2 = scnr.next();
    String denominator2 = scnr.next();

    Rational r1 = new Rational(new BigInteger(numerator1), new BigInteger(denominator1));
    Rational r2 = new Rational(new BigInteger(numerator2), new BigInteger(denominator2));

    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    System.out.println(r2 + " is " + r2.doubleValue());
  }
}
