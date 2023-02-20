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
            int[] x_cord = new int[4];
            int[] y_cord = new int[4];

            for (int row = 0; row < 9; ++ row)
            {
                for (int col = 0; col < 9; ++ col)
                {
                    int num = scnr.nextInt();
                    board[row][col] = num;
                    if (num == 0 & num_zero < 4)
                    {
                        x_cord[num_zero] = row;
                        y_cord[num_zero] = col;
                        ++ num_zero;
                    }
                }
            }

            if (num_zero == 1){
                System.out.print("(" + x_cord[0] + "," + y_cord[0] + "," + horizontal(x_cord[0],board) + ")");
            }
            if (num_zero == 2){
                if (x_cord[0] != x_cord[1]){
                    System.out.print("\n(" + x_cord[0] + "," + y_cord[0] + "," + horizontal(x_cord[0],board) + ")");
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + horizontal(x_cord[1],board) + ")");
                } else {
                    System.out.print("\n(" + x_cord[0] + "," + y_cord[0] + "," + vertical(y_cord[0],board) + ")");
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + vertical(y_cord[1],board) + ")");
                }
            }
            if (num_zero == 3){
                if (y_cord[0] == y_cord[1] & y_cord[0] == y_cord[2]){
                    System.out.print("\n(" + x_cord[0] + "," + y_cord[0] + "," + horizontal(x_cord[0],board) + ")");
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + horizontal(x_cord[1],board) + ")");
                    System.out.print(" (" + x_cord[2] + "," + y_cord[2] + "," + horizontal(x_cord[2],board) + ")");
                } else if (x_cord[0] == x_cord[1] & x_cord[0] == x_cord[2]){
                    System.out.print("\n(" + x_cord[0] + "," + y_cord[0] + "," + vertical(y_cord[0],board) + ")");
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + vertical(y_cord[1],board) + ")");
                    System.out.print(" (" + x_cord[2] + "," + y_cord[2] + "," + vertical(y_cord[2],board) + ")");
                } else if (x_cord[0] != x_cord[1] & x_cord[1] == x_cord[2]){
                    // solve the first one horizontally and set it in the board, so we can solve the other two vertically
                    System.out.print("\n(" + x_cord[0] + "," + y_cord[0] + "," + horizontal(x_cord[0],board) + ")");
                    board[x_cord[0]][y_cord[0]] = horizontal(x_cord[0],board);
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + vertical(y_cord[1],board) + ")");
                    System.out.print(" (" + x_cord[2] + "," + y_cord[2] + "," + vertical(y_cord[2],board) + ")");
                } else {
                    //  solve the last one horizontally and set it in the board, so we can solve the other two vertically
                    System.out.print("\n(" + x_cord[2] + "," + y_cord[2] + "," + horizontal(x_cord[2],board) + ")");
                    board[x_cord[2]][y_cord[2]] = horizontal(x_cord[2],board);
                    System.out.print(" (" + x_cord[0] + "," + y_cord[0] + "," + vertical(y_cord[0],board) + ")");
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + vertical(y_cord[1],board) + ")");
                }
            }
        } while (num_zero < 4);
        scnr.close();
        System.out.println("\nEND");
    }


    public static int vertical(int col, int[][] board){

        // array with all numbers in column
        int[] numbers = new int[9];

        // puts all numbers in a column in here and sorts to find the missing one
        for (int i = 0; i < 9; ++ i)
        {
            numbers[i] = board[i][col];
        }
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


    public static int horizontal(int row, int[][] board){

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



}
