import java.util.*;

public class Suduko {

    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in);

        int num_zero;

        do {

            // number of zeros in a given board
            num_zero = 0;

            // initializing the board
            int[][] board = new int[9][9];

            // initializing the answer
            int[][] zero_cord = new int [3][2];


            for (int row = 0; row < 9; ++ row)
            {
                for (int col = 0; col < 9; ++ col)
                {
                    int num = scnr.nextInt();
                    board[row][col] = num;
                    if (num == 0)
                    {
                        zero_cord[num_zero][0] = row;
                        zero_cord[num_zero][1] = col;
                        ++ num_zero;
                    }
                }
            }


        } while (num_zero < 81);


    }


    public static int type_1(int[][] board, int row){
        // array with all numbers in row
        int[] numbers = new int[9];

        // puts all numbers in a row in here and sorts to find the missing one
        System.arraycopy(board[row], 0, numbers, 0, 9);
        Arrays.sort(numbers);

        // finds the missing one and returns the value to be put in a print statement
        int missing_int = 9;

        for (int i = 1; i < 9; ++i)
        {
            if (numbers[i] != i)
            {
                missing_int = i;
                break;
            }
        }
        return missing_int;
    }

    public static int[] type_2(int[][] board, int[][] zero_cord){
        int[] answers = new int[2];

        if (zero_cord[0][0] == zero_cord[1][0])
        {
            // horizontal
            for (int i = 0; i < 2; ++ i){
                // array with all numbers in row
                int[] numbers = new int[9];

                // puts all numbers in a row in here and sorts to find the missing one
                System.arraycopy(board[zero_cord[i][0]], 0, numbers, 0, 9);
                Arrays.sort(numbers);

                // finds the missing one and returns the value to be put in a print statement
                int missing_int = 9;

                for (int j = 1; j < 9; ++j)
                {
                    if (numbers[j] != j)
                    {
                        missing_int = j;
                        break;
                    }
                }
                answers[i] = missing_int;
            }
        }
        else
        {
            // vertical
            for (int i = 0; i < 2; ++ i){
                // array with all numbers in column
                int[] numbers = new int[9];

                // puts all numbers in a column in here and sorts to find the missing one
                for (int k = 0; k < 9; ++ k)
                {
                    numbers[k] = board[k][zero_cord[0][i]];
                }
                Arrays.sort(numbers);

                // finds the missing one and returns the value to be put in a print statement
                int missing_int = 9;

                for (int j = 1; j < 9; ++j)
                {
                    if (numbers[j] != j)
                    {
                        missing_int = j;
                        break;
                    }
                }
            }

        }



    }



}
