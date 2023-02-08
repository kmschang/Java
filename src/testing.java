
import java.util.Scanner;

public class testing {

    public static void main(String[] args) {

        String s = "test ";

        int num1 = 1;
        int num2 = 2;
        int num3 = 3;

        s = new StringBuilder().append(s).append("(").append(num1).append(",").append(num2).append(")").toString();

        System.out.println(s);

        // This is me adding a test to the testing file

    }

    public static double mean(double[] x){

        double total = 0;
        for (int i = 0; i < 10; ++ i){
            total = total + x[i];
        }

        return total/10;

    }

    public static double deviation (double[] x){

        double total = 0;
        for (int i = 0; i < 10; ++ i){
            total = total + x[i];
        }

        double mean = total / 10;

        double total_minus_mean = 0;

        for (int i = 0; i < 10; ++i){
            double value = x[i] - mean;
            value = value * value;
            total_minus_mean = total_minus_mean + value;
        }

        double under_radical = total_minus_mean / 9;
        return Math.sqrt(under_radical);

    }

}
