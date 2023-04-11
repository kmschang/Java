public class FirstIndex {
  public static void main(String[] args) {
    int dim = 4;
    int row = 0;
    int col = 0;
    for (int num = 0; num < Math.pow(dim, 2); ++num) {
      row = num / dim;
      col = num % dim;
    }
  }
}

class testing_print {
  public static void main(String[] args) {
    System.out.println("\u001B[35m");
    System.out.println(
        "         ____    _  _____ , ____    ____     _    __    __  ____      ");
    System.out.println(
        "         |      /_\\   |     |___    | ___   /_\\   | \\  / |  |___     ");
    System.out.println(
        "         |___  /   \\  |     ___|    |___|  /   \\  |  \\/  |  |___     ");
    System.out.print("\u001B[37m");
  }
}
