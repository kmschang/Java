import java.util.ArrayList;
import java.util.Scanner;

public class Exercise11_13 {


    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); ++ i){
            if (!temp.contains(list.get(i))){
                temp.add(list.get(i));
            }
        }

        list.clear();
        list.addAll(temp);
    }

    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter ten integers: ");
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; ++ i){
            list.add(scnr.nextInt());
        }

        removeDuplicate(list);

        System.out.println("The distinct integers are: ");
        for (int i = 0; i < list.size(); ++ i){
            System.out.print(list.get(i) + " ");
        }


    }


}



