public class Shape {

    static double area;
    static double perimeter;
    static double radius;

    Shape() {}

    Shape(double radius) throws InvalidParameterException{
        if (radius < 0) {
            throw new InvalidParameterException(radius);
        } else {
            Shape.radius = radius;
        }
    }

    Shape(double area, double perimeter) throws InvalidParameterException{
        if (area < 0 || perimeter < 0) {
            throw new InvalidParameterException(area);
        } else {
            Shape.area = area;
            Shape.perimeter = perimeter;
        }
    }

    public static double getArea() {
        return area;
    }

    public static double getPerimeter() {
        return perimeter;
    }



    public static void main(String[] args) {
        try 
        {
            Circle c1 = new Circle(0);
            System.out.println(c1.getArea());
            Rectangle r1 = new Rectangle(2, 2);
            System.out.println(r1.getPerimeter());
        } 
        catch (InvalidParameterException ex) 
        {
            System.out.println(ex.getMessage());
        }
        

    }

}


class Circle extends Shape {

    static double radius;

    Circle() {}

    Circle(double radius) throws InvalidParameterException {
        if (radius < 0) {
            throw new InvalidParameterException(radius);
        } else {
            this.radius = radius;
        }
    }
    
    public static double getArea() {
        return Math.PI * radius * radius;
    }

    public static double getPerimeter() {
        return 2 * Math.PI * radius;
    }

}


class Rectangle extends Shape {

    static double width;
    static double height;

    Rectangle() {}

    Rectangle(double width, double height) throws InvalidParameterException {
        if (width < 0 || height < 0) {
            throw new InvalidParameterException(width);
        } else {
            this.width = width;
            this.height = height;
        }
    }

    public static double getArea() {
        return width * height;
    }

    public static double getPerimeter() {
        return 2 * (width + height);
    }

}









class InvalidParameterException extends Exception {

    private double parameter;

    InvalidParameterException(double parameter) {
        super ("Invalid parameter: " + parameter);
        this.parameter = parameter;
    }

    public double getParameter() {
        return parameter;
    }

}

