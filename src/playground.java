// Playground

class playground {
  public static void main(String[] args) {
    double sum = 0;
    for (double d = 0; d < 10; sum += sum + d) {
      d += 0.1;
    }
    int y = 0;
    for (int i = 0; i < 10; ++i) {
      y += 1;
    }
    System.out.println(y);
  }
}
