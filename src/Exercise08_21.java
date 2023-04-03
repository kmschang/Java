/*
 * Kyle Schang
 * EECS 1510
 * 2-09-23
 */

import java.util.*;

public class Exercise08_21 {

  public static void main(String[] args) {

    Scanner scnr = new Scanner(System.in);

    System.out.println("Enter the number of cities:");
    int num_cities = scnr.nextInt();

    System.out.println("Enter the coordinates of the cities: ");

    double[][] coordinates = new double[num_cities][2];
    for (int i = 0; i < num_cities; ++i) {
      coordinates[i][0] = scnr.nextDouble();
      coordinates[i][1] = scnr.nextDouble();
    }

    double[][] central_city = {{coordinates[0][0]}, {coordinates[0][1]}};
    double central_city_distance = 0;

    for (int i = 0; i < num_cities; ++i) {
      double total_distance = 0;
      for (int j = 0; j < num_cities; ++j) {
        double dis1 = Math.pow(coordinates[i][0] - coordinates[j][0], 2);
        double dis2 = Math.pow(coordinates[i][1] - coordinates[j][1], 2);
        double add_dis = dis1 + dis2;
        double distance = Math.sqrt(add_dis);
        total_distance = total_distance + distance;
      }
      if (i == 0) {
        central_city_distance = total_distance;
      }
      if (i != 0 & total_distance < central_city_distance) {
        central_city_distance = total_distance;
        central_city[0][0] = coordinates[i][0];
        central_city[1][0] = coordinates[i][1];
      }
    }

    System.out.println("The central city is at (" + central_city[0][0] + ", " +
                       central_city[1][0] + ")");
    System.out.printf("The total distance to all other cities is %.2f",
                      central_city_distance);
  }
}
