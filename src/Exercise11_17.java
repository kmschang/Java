// kyle
import java.util.*;

public class Exercise11_17 {

    Scanner scnr = new Scanner(System.in);
    static ArrayList<Integer> primeFactors = new ArrayList<Integer>();
    static ArrayList<Integer> oddPrimeFactors = new ArrayList<Integer>();

    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter an integer m : ");
        int m = scnr.nextInt();
        int original = m;


        do {
            m = pf(m);
        } while (m != 1);

        int index = 0;
        for (int i = 2; i < original/2; ++ i){
            int appearance = 0;
            for (int j = 0; j < (primeFactors.size()); ++ j){
                if (primeFactors.get(j) == i) ++ appearance;
            }
            if (appearance % 2 != 0){
                oddPrimeFactors.add(primeFactors.get(index));
            }
            if (appearance != 0){
                index = index + appearance;
            }
        }

        int n = oddPrimeFactors.get(0);

        for (int i = 1; i < oddPrimeFactors.size(); ++ i){
            n = n * oddPrimeFactors.get(i);
        }

        System.out.println("The smallest number n for m x n to be a perfect square is " + n);
        System.out.println("m x n is " + n*original);




    }

    public static int pf(int number){
        for (int i = 2; i <= number; ++ i){
            if (number % i == 0){
                primeFactors.add(i);
                return number / i;
            }
        }
        return number;
    }


}
