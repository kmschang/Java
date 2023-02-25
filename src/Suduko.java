/*
 * Kyle Schang
 * EECS 1510
 *
 * Suduko Project
 *
 * Do loop to find the all zero board. While scanning them in, I check for zero and report where they are. I then later check for what type of problem it is. Then I solve it and print the answers to the console.
 *
 */


// import scanner
import java.util.*;

public class Suduko {

    public static void main(String[] args){

        // initializing scanner
        Scanner scnr = new Scanner(System.in);

        // initializing variables
        // num_zero for the number of zeros found in the board, used to determine which way to solve
        // num_board for the number of boards that have been scanned in, used for formatting at the end
        int num_zero;
        int num_board = 0;

        // main loop to scan board and solve. Checking until board = 0.
        do {
            // number of zeros in a given board
            num_zero = 0;

            // initializing the board
            int[][] board = new int[9][9];

            // initializing the answer, one array for the x values and one for the y values, the indexes should match up
            int[] x_cord = new int[4];
            int[] y_cord = new int[4];

            // for loop to make the board in array form and see where the zeros are
            for (int row = 0; row < 9; ++ row)
            {
                for (int col = 0; col < 9; ++ col)
                {
                    // num is a placeholder, the number that was just scanned, that way I can use if more than once in the block of code
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

            // Printing Formatting
            if (num_board != 0)
            {
                System.out.print("\n");
            }

            // printing the results using other methods to find the missing variable/s
            // one missing variable
            if (num_zero == 1)
            {
                // solves horizontally
                System.out.print("(" + x_cord[0] + "," + y_cord[0] + "," + horizontal(x_cord[0],board) + ")");
            }
            // two missing variables
            if (num_zero == 2)
            {
                if (x_cord[0] != x_cord[1])
                {
                    // solves both horizontally
                    System.out.print("(" + x_cord[0] + "," + y_cord[0] + "," + horizontal(x_cord[0],board) + ")");
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + horizontal(x_cord[1],board) + ")");
                }
                else
                {
                    // solves both vertically
                    System.out.print("(" + x_cord[0] + "," + y_cord[0] + "," + vertical(y_cord[0],board) + ")");
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + vertical(y_cord[1],board) + ")");
                }
            }
            // three missing variables
            if (num_zero == 3)
            {
                if (y_cord[0] == y_cord[1] & y_cord[0] == y_cord[2])
                {
                    // solves them all horizontally
                    System.out.print("(" + x_cord[0] + "," + y_cord[0] + "," + horizontal(x_cord[0],board) + ")");
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + horizontal(x_cord[1],board) + ")");
                    System.out.print(" (" + x_cord[2] + "," + y_cord[2] + "," + horizontal(x_cord[2],board) + ")");
                }
                else if (x_cord[0] == x_cord[1] & x_cord[0] == x_cord[2])
                {
                    // solves them all vertically
                    System.out.print("(" + x_cord[0] + "," + y_cord[0] + "," + vertical(y_cord[0],board) + ")");
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + vertical(y_cord[1],board) + ")");
                    System.out.print(" (" + x_cord[2] + "," + y_cord[2] + "," + vertical(y_cord[2],board) + ")");
                }
                else if (x_cord[0] != x_cord[1] & x_cord[1] == x_cord[2])
                {
                    // solve the first one horizontally and set it in the board, so we can solve the other two vertically
                    System.out.print("(" + x_cord[0] + "," + y_cord[0] + "," + horizontal(x_cord[0],board) + ")");
                    board[x_cord[0]][y_cord[0]] = horizontal(x_cord[0],board);
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + vertical(y_cord[1],board) + ")");
                    System.out.print(" (" + x_cord[2] + "," + y_cord[2] + "," + vertical(y_cord[2],board) + ")");
                }
                else
                {
                    //  solve the last one horizontally and set it in the board, so we can solve the other two vertically
                    System.out.print("(" + x_cord[2] + "," + y_cord[2] + "," + horizontal(x_cord[2],board) + ")");
                    board[x_cord[2]][y_cord[2]] = horizontal(x_cord[2],board);
                    System.out.print(" (" + x_cord[0] + "," + y_cord[0] + "," + vertical(y_cord[0],board) + ")");
                    System.out.print(" (" + x_cord[1] + "," + y_cord[1] + "," + vertical(y_cord[1],board) + ")");
                }
            }
            // used with formatting the answer
            ++ num_board;
        } while (num_zero < 4);

        // close scanner
        scnr.close();

        // print END to finish off program
        System.out.println("END");
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

        // finds the missing one and returns the value to be put in a print statement, by default its 9 to eliminate and else statement
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

        // finds the missing one and returns the value to be put in a print statement, by default its 9 to eliminate and else statement
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
