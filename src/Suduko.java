/*
 * Kyle Schang
 * EECS 1510
 * Started Jan  31st  - Finished Feb 7th - 35 hours Total
 *
 * This is my program used to solve an unknown number of Suduko boards. It takes in all the numbers with one big scanner and put it into one big multidimensional array.
 * Then it takes them out one board at a time and solves them. After solving, it puts the answers into an array and at the end, it prints all the solutions.
 * I tried to use as many functions as I could, but it got a lot because I had to input functions into functions.
 * The hardest part was trying to figure out how to take everything in with one scanner with an unknown amount of boards and then still solve them.
 * The second-hardest part was wrapping my head around arrays and making them all fit and work together.
 *
 */

// import all the necessary methods
import java.util.Arrays;
import java.util.Scanner;

public class Suduko {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        // while loop to scan in one board at a time
        while (true) {
            int[][] board = new int[9][9];

            int num_zero = 0;

            for (int row = 0; row < 9; ++row)
            {
                for (int col = 0; col < 9; ++col)
                {
                    int num = scnr.nextInt();
                    board[row][col] = num;
                    if (num == 0){
                        ++ num_zero;
                    }
                }
            }
            if (num_zero == 81)
            {
                int[][] zero_board = new int[9][9];
                scnr.close();
                break;
            }


            if (zero(board).length == 1)
            {
                System.out.println("("+ zero(board)[0][0]+","+ zero(board)[0][1]+","+horizontal(zero(board)[0][0], board)+")");
            }

            else if (zero(board).length == 2) {
                if (two_missing(zero(board))) {
                    int num_row = 0;
                    for (int i = 0; i < 2; ++i) {
                        int a = horizontal(zero(board)[i][0], board);
                        int x = zero(board)[i][0];
                        int y = zero(board)[i][1];

                        if (num_print == 0 & num_row == 0) {
                            answers.append("(").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        } else if (num_print != 0 & num_row == 0) {
                            answers.append("\n(").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        } else {
                            answers.append(" (").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        }
                    }
                }
                // need to solve both vertically
                else {
                    int num_row = 0;
                    for (int i = 0; i < 2; ++i) {
                        int a = vertical(zero(board)[i][1], board);
                        int x = zero(board)[i][0];
                        int y = zero(board)[i][1];

                        if (num_print == 0 & num_row == 0) {
                            answers.append("(").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        } else if (num_print != 0 & num_row == 0) {
                            answers.append("\n(").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        } else {
                            answers.append(" (").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        }
                    }
                }
            }
            // three missing in a board
            else if (zero(board).length == 3) {
                // need to solve all horizontally
                if (three_missing(zero(board)) == 1) {
                    int num_row = 0;
                    for (int i = 0; i < 3; ++i) {
                        int a = horizontal(zero(board)[i][0], board);
                        int x = zero(board)[i][0];
                        int y = zero(board)[i][1];

                        if (num_print == 0 & num_row == 0) {
                            answers.append("(").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        } else if (num_print != 0 & num_row == 0) {
                            answers.append("\n(").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        } else {
                            answers.append(" (").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        }
                    }
                }
                // need to solve all vertically
                else if (three_missing(zero(board)) == 2) {
                    int num_row = 0;
                    for (int i = 0; i < 3; ++i) {
                        int a = vertical(zero(board)[i][1], board);
                        int x = zero(board)[i][0];
                        int y = zero(board)[i][1];

                        if (num_print == 0 & num_row == 0) {
                            answers.append("(").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        } else if (num_print != 0 & num_row == 0) {
                            answers.append("\n(").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        } else {
                            answers.append(" (").append(x).append(",").append(y).append(",").append(a).append(")");
                            ++num_print;
                            ++num_row;
                        }
                    }
                }
                // need to solve first one horizontally and then the other two vertically once we put the other back into the board
                else if (three_missing(zero(board)) == 3) {

                    int a = horizontal(zero(board)[0][0], board);
                    int x = zero(board)[0][0];
                    int y = zero(board)[0][1];
                    board[zero(board)[0][0]][zero(board)[0][1]] = horizontal(zero(board)[0][0], board);

                    if (num_print == 0)
                    {
                        answers.append("(").append(x).append(",").append(y).append(",").append(a).append(")");
                    }
                    else
                    {
                        answers.append("\n(").append(x).append(",").append(y).append(",").append(a).append(")");
                    }
                    ++num_print;

                    for (int i = 0; i < 2; ++i)
                    {
                        int aa = vertical(zero(board)[i][1], board);
                        int xx = zero(board)[i][0];
                        int yy = zero(board)[i][1];

                        answers.append(" (").append(xx).append(",").append(yy).append(",").append(aa).append(")");
                        ++num_print;
                    }
                }
                // need to solve the last one horizontally and then the other two vertically once we put the other back into the board
                else if (three_missing(zero(board)) == 4) {
                    int a = horizontal(zero(board)[2][0], board);
                    int x = zero(board)[2][0];
                    int y = zero(board)[2][1];
                    board[zero(board)[2][0]][zero(board)[2][1]] = horizontal(zero(board)[2][0], board);

                    if (num_print == 0)
                    {
                        answers.append("(").append(x).append(",").append(y).append(",").append(a).append(")");
                    }
                    else
                    {
                        answers.append("\n(").append(x).append(",").append(y).append(",").append(a).append(")");
                    }
                    ++num_print;

                    for (int i = 0; i < 2; ++i)
                    {
                        int aa = vertical(zero(board)[i][1], board);
                        int xx = zero(board)[i][0];
                        int yy = zero(board)[i][1];

                        answers.append(" (").append(xx).append(",").append(yy).append(",").append(aa).append(")");
                        ++num_print;
                    }
                }
            }
        }

        // print_answers(answers, num_boards);
        System.out.println("END");
    }

    // finds how many zeros there are and puts them into an array to come back to
    public static int[][] zero(int[][] board){

        // sets number of zero
        int num_zero = 0;

        // checks numbers of zeros in smaller board
        for (int i = 0; i < 9; ++i)
        {
            for(int j = 0; j < 9; ++j)
            {
                if (board[i][j] == 0){
                    ++ num_zero;
                }
            }
        }

        // makes multidimensional array with x and y coordinate for printing later
        int[][] zero_cord = new int[num_zero][2];

        // x coordinate of array where the x values are stored. increased each loop so a number is placed in its respective spot
        int x = 0;

        for (int i = 0; i < 9; ++i)
        {
            for(int j = 0; j < 9; ++j)
            {
                if (board[i][j] == 0)
                {
                    zero_cord[x][0] = i;
                    zero_cord[x][1] = j;
                    ++ x;
                }
            }
        }
        return zero_cord;
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


    // determine which way we need to solve with two missing
    public static boolean two_missing(int[][] zero_cord){
        // true = horizontal, false = vertical
        return zero_cord[0][0] != zero_cord[1][0];
    }


    // determine which way we need to solve with three missing
    public static int three_missing(int[][] zero_cord){
        if (zero_cord[0][0] != zero_cord[1][0] & zero_cord[1][0] != zero_cord[2][0] & zero_cord[0][0] != zero_cord[2][0])
        {
            // all horizontal
            return 1;
        }
        else if (zero_cord[0][1] != zero_cord[1][1] & zero_cord[1][1] != zero_cord[2][1] & zero_cord[0][1] != zero_cord[2][1])
        {
            // all vertical
            return 2;
        }
        else if (zero_cord[0][0] != zero_cord[1][0] & zero_cord[1][0] == zero_cord[2][0])
        {
            // solve the first one horizontally and set it in the board, so we can solve the other two vertically
            return 3;
        }
        else
        {
            //  solve the last one horizontally and set it in the board, so we can solve the other two vertically
            return 4;
        }

    }

}

