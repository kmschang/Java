public class FirstIndex {
  public static void main(String[] args) {
    int dim = 3;
    for (int num = 0; num < Math.pow(dim, 2); ++num) {
      System.out.println(num + 1);
      System.out.println("row=" + num / dim);
      System.out.println("col=" + num % dim);
    }
    System.out.println("Or maybe I got the row/col backwards.");
  }
}
