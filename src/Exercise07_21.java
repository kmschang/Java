/*
 * Kyle Schang
 * EECS 1510
 * 03-02-23
 */

import java.util.Scanner;
import java.util.Arrays;

public class Exercise07_21
{

    public static void main(String[] args)
    {

        Scanner scnr = new Scanner(System.in);

        int sum = 0;

        for (int i = 0; i < args.length; ++i){
            // scan from command line (string type)
            String num_string = args[i];
            // change string to int
            int num_int = Integer.parseInt(num_string);
            // add int to the sum
            sum = sum + num_int;
        }

        System.out.println("The totoal is " + sum);

    }

}
