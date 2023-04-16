public class FirstIndex {
  public static void main(String[] args) {
    int dim = 4;
    int row = 0;
    int col = 0;
    for (int num = 0; num < Math.pow(dim, 2); ++num) {
      row = num / dim;
      col = num % dim;
      System.out.println(row);
      System.out.println(col);
    }
  }
}

class testing_1 {
  public static void main(String[] args) { System.out.println("THIS IS A TEST"); }
}

class free {

  public static void main(String[] args) {
    java.util.Date x = new java.util.Date();
    java.util.Date y = x.clone();
    System.out.println(x = y);
  }
}
