public class testing {
  public static void main(String[] args) {

    int num = 0;
    int firstDigit = 0;
    int lastDigit = 0;

    num = (int)(Math.random() * 899 + 100);
    lastDigit = num % 10;
    firstDigit = num / 100;

    while ((lastDigit - firstDigit) < 2 && (lastDigit - firstDigit) > -2) {
      num = (int)(Math.random() * 899 + 100);
      lastDigit = num % 10;
      firstDigit = num / 100;
    }

    System.out.println(num);
  }
}
