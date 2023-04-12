public class Exercise09_01 {

  private double width = 1;
  private double length = 1;

  Exercise09_01() {}

  Exercise09_01(double width, double length) {
    this.width = width;
    this.length = length;
  }

  double getArea() { return width * length; }

  double getPerimeter() { return (2 * width) + (2 * length); }

  public static void main(String[] args) {
    Exercise09_01 rectangle1 = new Exercise09_01(4, 40);
    Exercise09_01 rectangle2 = new Exercise09_01(3.5, 35.9);

    System.out.println("The area of a rectangle with width " + rectangle1.width + " and height " + rectangle1.length +
                       " is " + rectangle1.getArea());
    System.out.println("The perimeter of a rectangle is " + rectangle1.getPerimeter());
    System.out.println("The area of a rectangle with width " + rectangle2.width + " and height " + rectangle2.length +
                       " is " + rectangle2.getArea());
    System.out.println("The perimeter of a rectangle is " + rectangle2.getPerimeter());
  }
}
