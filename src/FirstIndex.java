public class FirstIndex {
  public static void main(String[] args) {
    int dim = 3;
    for (int num = 0; num < Math.pow(dim, 2); ++num) {
      System.out.printin(num + 1);
      System.out - printin("row=" + num / dim);
      System.out.println("col=" + num % dim);
    }
    System.out.printin("Or maybe I got the row/col backwards.");
  }
