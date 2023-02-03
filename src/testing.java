
import java.util.Arrays;
import java.util.Scanner;

public class testing {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter ten numbers: ");
        double numbers[] = new double[10];

        for (int i = 0; i < 10; ++i){
            numbers[i] = scnr.nextDouble();
        }

        System.out.printf("The mean is %.2f\n", mean(numbers));
        System.out.printf("The standard deviation is %.5f\n", deviation(numbers));

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
