public class Exercise09_09 {

  private int n = 3;
  private double side = 1;
  private double x = 0;
  private double y = 0;

  Exercise09_09() {}

  Exercise09_09(int n, double side) {
    this.n = n;
    this.side = side;
  }

  Exercise09_09(int n, double side, double x, double y) {
    this.n = n;
    this.side = side;
    this.x = x;
    this.y = y;
  }

  public double getPerimeter() { return n * side; }

  public double getArea() { return (n * side * side) / (4 * (Math.tan(Math.PI / n))); }

  public static void main(String[] args) {

    Exercise09_09 polygon1 = new Exercise09_09();
    Exercise09_09 polygon2 = new Exercise09_09(6, 4);
    Exercise09_09 polygon3 = new Exercise09_09(10, 4, 5.6, 7.8);

    System.out.println("Polygon 1 perimeter: " + polygon1.getPerimeter());
    System.out.println("Polygon 1 area: " + polygon1.getArea());
    System.out.println("Polygon 2 perimeter: " + polygon2.getPerimeter());
    System.out.println("Polygon 2 area: " + polygon2.getArea());
    System.out.println("Polygon 3 perimeter: " + polygon3.getPerimeter());
    System.out.println("Polygon 3 area: " + polygon3.getArea());
  }
}
