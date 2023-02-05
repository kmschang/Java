/*
 * Kyle Schang
 * EECS 1510
 * Started Jan  31st  - Finished Feb 1st - 10 hours Total
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

        // initializing the number of boards to zero
        int num_boards = 0;
        Scanner scnr = new Scanner(System.in);

        // initializing the answer array
        int[][][] answers = new int[9][3][3];

        // while loop to scan in one board at a time
        while (true) {
            int[][] board = new int[9][9];

            int board_total = 0;
            for (int row = 0; row < 9; ++row) {
                int row_total = 0;
                for (int col = 0; col < 9; ++col) {
                    int num = scnr.nextInt();
                    board[row][col] = num;
                    row_total = row_total + num;
                }
                board_total = board_total + row_total;
            }
            if (board_total == 0){
                int[][] zero_board = new int[9][9];
                print_board(zero_board);
                scnr.close();
                break;
            } else {
                print_board(board);
                ++ num_boards;
            }

            if (check_for_zero(board).length == 1){
                answers[num_boards-1][0][0] = horizontal(check_for_zero(board)[0][0], board);
                answers[num_boards-1][0][1] = check_for_zero(board)[0][0];
                answers[num_boards-1][0][2] = check_for_zero(board)[0][1];
            }
            else if (check_for_zero(board).length == 2){
                if (two_missing(check_for_zero(board)) == 1){
                    for (int i = 0; i < 2; ++i){
                        answers[num_boards-1][i][0] = horizontal(check_for_zero(board)[i][0], board);
                        answers[num_boards-1][i][1] = check_for_zero(board)[i][0];
                        answers[num_boards-1][i][2] = check_for_zero(board)[i][1];
                    }
                }
                else {
                    for (int i = 0; i < 2; ++i){
                        answers[num_boards-1][i][0] = vertical(check_for_zero(board)[i][1], board);
                        answers[num_boards-1][i][1] = check_for_zero(board)[i][0];
                        answers[num_boards-1][i][2] = check_for_zero(board)[i][1];
                    }
                }
            }
            else if (check_for_zero(board).length == 3){
                if (three_missing(check_for_zero(board)) == 1){
                    for (int i = 0; i < 3; ++i) {
                        answers[num_boards - 1][i][0] = horizontal(check_for_zero(board)[i][0], board);
                        answers[num_boards - 1][i][1] = check_for_zero(board)[i][0];
                        answers[num_boards - 1][i][2] = check_for_zero(board)[i][1];
                    }
                }
                else if (three_missing(check_for_zero(board)) == 2){
                    for (int i = 0; i < 3; ++i){
                        answers[num_boards-1][i][0] = vertical(check_for_zero(board)[i][1], board);
                        answers[num_boards-1][i][1] = check_for_zero(board)[i][0];
                        answers[num_boards-1][i][2] = check_for_zero(board)[i][1];
                    }
                }
                else if (three_missing(check_for_zero(board)) == 3){
                    answers[num_boards-1][0][0] = horizontal(check_for_zero(board)[0][0], board);
                    answers[num_boards-1][0][1] = check_for_zero(board)[0][0];
                    answers[num_boards-1][0][2] = check_for_zero(board)[0][1];
                    board[check_for_zero(board)[0][0]][check_for_zero(board)[0][1]] = horizontal(check_for_zero(board)[0][0], board);
                    answers[num_boards-1][1][0] = vertical(check_for_zero(board)[0][1], board);
                    answers[num_boards-1][1][1] = check_for_zero(board)[0][0];
                    answers[num_boards-1][1][2] = check_for_zero(board)[0][1];
                    answers[num_boards-1][2][0] = vertical(check_for_zero(board)[1][1], board);
                    answers[num_boards-1][2][1] = check_for_zero(board)[1][0];
                    answers[num_boards-1][2][2] = check_for_zero(board)[1][1];
                }
                else if (three_missing(check_for_zero(board)) == 4){
                    answers[num_boards-1][0][0] = horizontal(check_for_zero(board)[2][0], board);
                    answers[num_boards-1][0][1] = check_for_zero(board)[2][0];
                    answers[num_boards-1][0][2] = check_for_zero(board)[2][1];
                    board[check_for_zero(board)[2][0]][check_for_zero(board)[2][1]] = horizontal(check_for_zero(board)[2][0], board);
                    answers[num_boards-1][1][0] = vertical(check_for_zero(board)[0][1], board);
                    answers[num_boards-1][1][1] = check_for_zero(board)[0][0];
                    answers[num_boards-1][1][2] = check_for_zero(board)[0][1];
                    answers[num_boards-1][2][0] = vertical(check_for_zero(board)[1][1], board);
                    answers[num_boards-1][2][1] = check_for_zero(board)[1][0];
                    answers[num_boards-1][2][2] = check_for_zero(board)[1][1];
                }
            }
        }


    }

    // method early on to print a particular board to make sure it is working
    public static void print_board(int[][] board){

        for (int i = 0; i < 9; ++i) 
        {
            for(int j = 0; j < 9; ++j)
            {
                System.out.print(board[i][j]);
                if (j != 8) {
                    System.out.print(" ");
                } 
                if (j == 8 & i != 8) 
                {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    // finds how many zeros there are and puts them into an array to come back to
    public static int[][] check_for_zero(int[][] board){

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

        for (int i = 1; i < 9; ++i){
            if (numbers[i] != i){
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
        for (int i = 0; i < 9; ++ i)
        {
            numbers[i] = board[row][i];
        }
        Arrays.sort(numbers);

        // finds the missing one and returns the value to be put in a print statement
        int missing_int = 9;

        for (int i = 1; i < 9; ++i){
            if (numbers[i] != i){
                missing_int = i;
                break;
            }
        }
        return missing_int;
    }


    // determine which way we need to solve with two missing
    public static int two_missing(int[][] zero_cord){
        if (zero_cord[0][0] != zero_cord[1][0])
        {
            // need to do horizontal for both
            return 1;
        }
        else 
        {
            // need to do vertical for both
            return 2;
        }
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
        else if (zero_cord[2][0] != zero_cord[1][0] & zero_cord[1][0] == zero_cord[0][0])
        {
            //  solve the last one horizontally and set it in the board, so we can solve the other two vertically
            return 4;
        } 
        else 
        {
            // combination doesn't work, which it should never.
            return 5;
        }
    }

}
