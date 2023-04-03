public class Exercise10_11 {

  public static void main(String[] args) {

    Circle2D circle1 = new Circle2D(2, 2, 5.5);
    System.out.println("Area is " + circle1.getArea());
    System.out.println("Perimeter is " + circle1.getPerimeter());
    System.out.println(circle1.contains(3, 3));
    System.out.println(circle1.contains(new Circle2D(4, 5, 10.5)));
    System.out.println(circle1.overlaps(new Circle2D(3, 5, 2.3)));
  }
}

class Circle2D {

  private double x;
  private double y;
  private double radius;

  Circle2D(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public double getArea() { return Math.PI * radius * radius; }

  public double getPerimeter() { return 2 * Math.PI * radius; }

  public boolean contains(double x, double y) {
    double xs = Math.pow(x - this.x, 2);
    double xy = Math.pow(y - this.y, 2);

    double distance = Math.sqrt(xs + xy);

    return (distance <= this.radius);
  }

  public boolean contains(Circle2D that) {
    double xs = Math.pow(that.x - this.x, 2);
    double xy = Math.pow(that.y - this.y, 2);

    double distance = Math.sqrt(xs + xy);

    return (distance + that.radius <= this.radius);
  }

  public boolean overlaps(Circle2D that) {
    double xs = Math.pow(that.x - this.x, 2);
    double xy = Math.pow(that.y - this.y, 2);

    double distance = Math.sqrt(xs + xy);

    return (this.radius + that.radius >= distance);
  }
}
