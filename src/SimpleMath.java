public class SimpleMath {

    static double num1;
    static double num2;

    public static void main(String[] args) {
        try {
            System.out.print(division.divide(10,0));
        } catch (InvalidDivision id) {
            System.out.print("Can't Divide by zero!!");
        }
    }

}

class multiply extends SimpleMath {

    multiply(){}
    multiply(double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    static double product(int num1, int num2){
        return num1 * num2;
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




class inputs {



}



class InvalidDivision extends Exception {

    InvalidDivision(){}


}

