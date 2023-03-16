public class Shape {

    static double area;
    static double perimeter;

    Shape() {}

    Shape(double area, double perimeter) {
        Shape.area = area;
        Shape.perimeter = perimeter;
    }

    public static double getArea() {
        return area;
    }

    public static double getPerimeter() {
        return perimeter;
    }



    public static void main(String[] args) {
        Circle c1 = new Circle(0);

        try{
            if (c1.radius < 0) {
                throw new InvalidRadiusException(c1.radius);
            }
            else if (c1.radius == 0) {
                throw new ZeroRadiusException(c1.radius);
            }
        } catch (InvalidRadiusException | ZeroRadiusException e) {
            System.out.println(e.getMessage());
        }
    }

}


class Circle extends Shape {

    static double radius;

    Circle() {}

    Circle(double radius) {
        Circle.radius = radius;
    }

    public static void setArea() {
        area = Math.PI * radius * radius;
    }

    public static void setPerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

}

class InvalidRadiusException extends Exception {

    InvalidRadiusException() {
        super("Invalid radius");
    }

    InvalidRadiusException(double radius) {
        super("Invalid radius: " + radius);
    }

}

class ZeroRadiusException extends Exception {

    ZeroRadiusException() {
        super("Zero radius");
    }

    ZeroRadiusException(double radius) {
        super("Zero radius: " + radius);
    }

}