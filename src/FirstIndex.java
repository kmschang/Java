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

    thanks_for_playing();
    title();
  }

  public static void thanks_for_playing() {
    System.out.println();
    System.out.println("\u001B[35m");
    System.out.println(
        "_____        _            ___   ___  __   _     _        _                ____");
    System.out.println(
        "  |   |__|  /_\\  |\\ | |/  |__   |__ |  | |_|   |_| |    /_\\   \\_/  | |\\ | | __");
    System.out.println(
        "  |   |  | /   \\ | \\| |\\  __|   |   |__| | \\   |   |__ /   \\   |   | | \\| |__|");
  }

  public static void title() {
    System.out.print("\u001B[32m");
    System.out.println(
        "           _____    ____   _____   _    ____   _____  ____  ___");
    System.out.println(
        "             |   |  |        |    /_\\   |        |    |  |  |__");
    System.out.println(
        "             |   |  |___     |   /   \\  |___     |    |__|  |__");
    System.out.println("\u001B[37m");
  }
}
