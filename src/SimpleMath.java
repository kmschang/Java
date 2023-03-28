public class SimpleMath {

    double num1;
    double num2;
    double num3;

    static double result;

    public static void main(String[] args) {
        try {
            System.out.println(addition.add(5, 6));
            System.out.println(division.divide(5, 0));
            System.out.println(multiply.product(5, 6));
            System.out.println(multiply.product(5, 6, 7));
        } catch (InvalidDivision id) {
            System.out.println("Can't Divide by zero!!");
        } finally {
            System.out.println(multiply.product(5, 6));
            System.out.println(multiply.product(5, 6, 7));
        }
    }

}

class multiply extends SimpleMath {

    static double product(double num1, double num2){
        result = num1 * num2;
        return result;
    }
    static double product(double num1, double num2, double num3){
        result = num1 * num2 * num3;
        return result;
    }

}

class addition extends SimpleMath {

    addition(){}
    addition(double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    static double add(double num1, double num2){
        return num1 + num2;
    }

}

class subtraction extends SimpleMath {

    subtraction(){}
    subtraction(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    static double subtract(double num1, double num2) {
        return num1 - num2;
    }

}


class division extends SimpleMath {

    division(){}
    division(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    static double divide(double num1, double num2) throws InvalidDivision {

        if (num1/num2 == Double.POSITIVE_INFINITY || num1/num2 == Double.NEGATIVE_INFINITY)
        {
            throw new InvalidDivision();
        } else {
            return num1/num2;
        }

    }
}




class InvalidDivision extends Exception {

    InvalidDivision(){}


}

