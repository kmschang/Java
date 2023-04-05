public class quizzes {

  public static void main(String[] args) {

    System.out.print("A,B;C".replaceAll(",;", "#") + " ");
    System.out.println("A,B;C".replaceAll("[,;]", "#"));
  }
}
