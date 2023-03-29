import java.util.*;

public class Exercise11_15 {

    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter the number of points: ");
        int numPoints = scnr.nextInt();
        System.out.println("Enter the coordinates of the points: ");
        double[][] points = new double[numPoints][2];
        for (int i = 0; i < numPoints; ++ i){
            points[i][0] = scnr.nextDouble();
            points[i][1] = scnr.nextDouble();
        }

        int numTriangles = numPoints - 2;

        double totalArea = 0;

        for (int j = 0; j < (numPoints - 2); ++ j){


            double sideOne = Math.sqrt(Math.pow(points[j + 1][1] - points[0][1], 2) + Math.pow(points[j + 1][0] - points[0][0], 2));
            double sideTwo = Math.sqrt(Math.pow(points[j + 2][1] - points[j + 1][1], 2) + Math.pow(points[j + 2][0] - points[j + 1][0], 2));
            double sideThree = Math.sqrt(Math.pow(points[j + 2][1] - points[0][1], 2) + Math.pow(points[j + 2][0] - points[0][0], 2));

            double s = (sideOne + sideTwo + sideThree) / 2;

            double triangleArea = Math.sqrt(s * (s - sideOne) * (s - sideTwo) * (s - sideThree));

            totalArea += triangleArea;

        }

        System.out.println("The total area is " + totalArea);





    }












}
