import java.util.Scanner;

public class Exercise08_01
{

    public static void main(String[] args)
    {

        double[][] numbers = new double[3][4];
        Scanner scnr = new Scanner(System.in);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 4; ++j) {
                numbers[i][j] = scnr.nextDouble();
            }
        }

        for (int k = 0; k < 4; ++k) {
            System.out.println("Sum of the elements at column " + k + " is " + sumColumn(numbers, k));
        }


    }

    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for (int i = 0; i < 3; ++i) {
            sum = sum + m[i][columnIndex];
        }
        return sum;
    }

}
