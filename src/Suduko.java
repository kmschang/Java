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

    public static void main(String[] args){

        // scan in all the boards
        // initializing the number of boards to zero
        int num_boards = 0;
        Scanner scnr = new Scanner(System.in);
        int[][] board = new int[63][9];

        // while loop to scan all the numbers in, no matter how many.
        while (true) 
        {
            // one board at a time, so we can recognize when we have the all zero one
            for (int k = 0; k < 9; ++k) 
            {
                // adding up board total, so we know when we have the 9x9 of all zeros
                int board_total = 0;
                for (int i = 0; i < 9; ++i) 
                {
                    // row_total counts towards board total
                    int row_total = 0;
                    for (int j = 0; j < 9; ++j) 
                    {
                        int num = scnr.nextInt();
                        int ii = i + (num_boards*9);
                        board[ii][j] = num;
                        row_total = row_total + num;
                    }
                    board_total = board_total + row_total;
                }
                // stopping if there is a board with all zeros, as per instructions
                if (board_total == 0) 
                {
                    System.out.println();
                    break;
                } 
                else
                {
                    ++num_boards;
                }
            }
            break;
        }

        // print the scanned boards
        print_all_boards(num_boards, board);

        // the main logic for solving smaller boards, need to iterate through all the smaller boards
        for (int n = 0; n < num_boards; ++n)
        {
            // checks the length of array with the coordinates of the zeros, if there is only one, easy to solve with type one vertical
            if (check_for_zero(one_board(n,board)).length == 1)
            {
                // initializing new variables/placeholders
                int x; int y; int z;

                // setting variables equal to x and y coordinate where the zero was and the value that should be there
                x = check_for_zero(one_board(n,board))[0][0];
                y = check_for_zero(one_board(n,board))[0][1];
                z = type_1_vertical(check_for_zero(one_board(n,board))[0][1],one_board(n,board));

                // printing the coordinates and value
                System.out.println("("+x+","+y+","+z+")");
            }
            // if the length is equal to two, two was to solve either both vertical or both horizontal
            else if (check_for_zero(one_board(n,board)).length == 2)
            {
                // checks to see if they are next to each other, they aren't, so we solve both horizontally
                if (two_missing(check_for_zero(one_board(n,board))) == 1)
                {
                    // main logic
                    int x; int y; int z;
                    x = check_for_zero(one_board(n,board))[0][0];
                    y = check_for_zero(one_board(n,board))[0][1];
                    z = type_1_horizontal(check_for_zero(one_board(n,board))[0][0],one_board(n,board));
                    System.out.print("("+x+","+y+","+z+")");

                    int a; int b; int c;
                    a = check_for_zero(one_board(n,board))[1][0];
                    b = check_for_zero(one_board(n,board))[1][1];
                    c = type_1_horizontal(check_for_zero(one_board(n,board))[1][0],one_board(n,board));
                    System.out.print(" ("+a+","+b+","+c+")\n");
                }
                // they are next to each other, so we solve them both vertically
                else 
                {
                    // main logic
                    int x; int y; int z;
                    x = check_for_zero(one_board(n,board))[0][0];
                    y = check_for_zero(one_board(n,board))[0][1];
                    z = type_1_vertical(check_for_zero(one_board(n,board))[0][1],one_board(n,board));
                    System.out.print("("+x+","+y+","+z+")");

                    int a; int b; int c;
                    a = check_for_zero(one_board(n,board))[1][0];
                    b = check_for_zero(one_board(n,board))[1][1];
                    c = type_1_vertical(check_for_zero(one_board(n,board))[1][1],one_board(n,board));
                    System.out.print(" ("+a+","+b+","+c+")\n");
                }
            }
            // there are three unknown values to solve for
            else 
            {
                // there are four different ways to solve, this one is all horizontally
                if (three_missing(check_for_zero(one_board(n,board))) == 1)
                {
                    // main logic
                    int x; int y; int z;
                    x = check_for_zero(one_board(n,board))[0][0];
                    y = check_for_zero(one_board(n,board))[0][1];
                    z = type_1_horizontal(check_for_zero(one_board(n,board))[0][0],one_board(n,board));
                    System.out.print("("+x+","+y+","+z+")");

                    int a; int b; int c;
                    a = check_for_zero(one_board(n,board))[1][0];
                    b = check_for_zero(one_board(n,board))[1][1];
                    c = type_1_horizontal(check_for_zero(one_board(n,board))[1][0],one_board(n,board));
                    System.out.print(" ("+a+","+b+","+c+")");

                    int d; int e; int f;
                    d = check_for_zero(one_board(n,board))[2][0];
                    e = check_for_zero(one_board(n,board))[2][1];
                    f = type_1_horizontal(check_for_zero(one_board(n,board))[2][0],one_board(n,board));
                    System.out.print(" ("+d+","+e+","+f+")\n");

                }
                // this one is all vertically
                else if (three_missing(check_for_zero(one_board(n,board))) == 2)
                {
                    // main logic
                    int x; int y; int z;
                    x = check_for_zero(one_board(n,board))[0][0];
                    y = check_for_zero(one_board(n,board))[0][1];
                    z = type_1_vertical(check_for_zero(one_board(n,board))[0][1],one_board(n,board));
                    System.out.print("("+x+","+y+","+z+")");

                    int a; int b; int c;
                    a = check_for_zero(one_board(n,board))[1][0];
                    b = check_for_zero(one_board(n,board))[1][1];
                    c = type_1_vertical(check_for_zero(one_board(n,board))[1][1],one_board(n,board));
                    System.out.print(" ("+a+","+b+","+c+")");

                    int d; int e; int f;
                    d = check_for_zero(one_board(n,board))[0][0];
                    e = check_for_zero(one_board(n,board))[2][1];
                    f = type_1_vertical(check_for_zero(one_board(n,board))[2][1],one_board(n,board));
                    System.out.print(" ("+d+","+e+","+f+")\n");

                }
                // this one if for an L shape
                else if (three_missing(check_for_zero(one_board(n,board))) == 3)
                {
                    // main logic
                    int x; int y; int z;
                    x = check_for_zero(one_board(n,board))[0][0];
                    y = check_for_zero(one_board(n,board))[0][1];
                    z = type_1_horizontal(check_for_zero(one_board(n,board))[0][0],one_board(n,board));
                    // changing the board to be the unknown, so we can solve the other to
                    board[x][y] = z;
                    System.out.print("("+x+","+y+","+z+")");

                    int a; int b; int c;
                    a = check_for_zero(one_board(n,board))[0][0];
                    b = check_for_zero(one_board(n,board))[0][1];
                    c = type_1_vertical(check_for_zero(one_board(n,board))[0][1],one_board(n,board));
                    System.out.print(" ("+a+","+b+","+c+")");

                    int d; int e; int f;
                    d = check_for_zero(one_board(n,board))[1][0];
                    e = check_for_zero(one_board(n,board))[1][1];
                    f = type_1_vertical(check_for_zero(one_board(n,board))[1][1],one_board(n,board));
                    System.out.print(" ("+d+","+e+","+f+")\n");

                }
                // this one is for an upside down L
                else if (three_missing(check_for_zero(one_board(n,board))) == 4)
                {
                    // main logic
                    int x; int y; int z;
                    x = check_for_zero(one_board(n,board))[2][0];
                    y = check_for_zero(one_board(n,board))[2][1];
                    z = type_1_horizontal(check_for_zero(one_board(n,board))[2][0],one_board(n,board));
                    // changing the board to be the unknown, so we can solve the other to
                    board[x][y] = z;
                    System.out.print("("+x+","+y+","+z+")");

                    int a; int b; int c;
                    a = check_for_zero(one_board(n,board))[0][0];
                    b = check_for_zero(one_board(n,board))[0][1];
                    c = type_1_vertical(check_for_zero(one_board(n,board))[0][1],one_board(n,board));
                    System.out.print(" ("+a+","+b+","+c+")");

                    int d; int e; int f;
                    d = check_for_zero(one_board(n,board))[1][0];
                    e = check_for_zero(one_board(n,board))[1][1];
                    f = type_1_vertical(check_for_zero(one_board(n,board))[1][1],one_board(n,board));
                    System.out.print(" ("+d+","+e+","+f+")\n");

                } 
                else
                {
                    System.out.println("Malfunction");
                }
            }
        }

        // printing the end statement as per the instructions
        System.out.println("END");

        // closing the scanner
        scnr.close();
    }

    // separate one board at a time from the large amount of numbers taken in by scanner
    public static int[][] one_board(int n, int board[][]){

        // makes a new temporary board just 9x9, so we can solve one board at a time
        int[][] s_board = new int[9][9];

        // initializing placeholders used later for interaction
        int num1 = 0;
        int num2 = 9;

        // making placeholders accurate based on which board we are getting from the massive board
        num1 = num1 + (n*9);
        num2 = num2 + (n*9);
        int num3 = num1-(n*9);

        // adding numbers from big board to smaller 9x9 board
        for (int i = num1; i < num2; ++i,++num3)
        {
            for (int j = 0; j < 9; ++j)
            {
                s_board[(num3)][j] = board[i][j];
            }
        }
        return s_board;
    }

    // method early on to print a particular board to make sure it is working
    public static void print_board(int[][] board){

        System.out.println();
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
                if (i == 8 & j == 8) 
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


    public static int type_1_vertical(int y, int[][] board){

        // array with all numbers in column
        int[] numbers = new int[9];

        // puts all numbers in a column in here and sorts to find the missing one
        for (int i = 0; i < 9; ++ i)
        {
            numbers[i] = board[i][y];
        }
        Arrays.sort(numbers);

        // finds the missing one and returns the value to be put in a print statement
        int missing_int;
        if (numbers[1] != 1)
        {
            missing_int = 1;
        } 
        else if (numbers[2] != 2
        		){
            missing_int = 2;
        } 
        else if (numbers[3] != 3)
        {
            missing_int = 3;
        } 
        else if (numbers[4] != 4)
        {
            missing_int = 4;
        } 
        else if (numbers[5] != 5)
        {
            missing_int = 5;
        } 
        else if (numbers[6] != 6)
        {
            missing_int = 6;
        } 
        else if (numbers[7] != 7)
        {
            missing_int = 7;
        } 
        else if (numbers[8] != 8)
        {
            missing_int = 8;
        } 
        else 
        {
            missing_int = 9;
        }
        return missing_int;
    }


    public static int type_1_horizontal(int x, int[][] board){

        // array with all numbers in row
        int[] numbers = new int[9];

        // puts all numbers in a row in here and sorts to find the missing one
        for (int i = 0; i < 9; ++ i)
        {
            numbers[i] = board[x][i];
        }
        Arrays.sort(numbers);

        // finds the missing one and returns the value to be put in a print statement
        int missing_int;
        if (numbers[1] != 1)
        {
            missing_int = 1;
        } 
        else if (numbers[2] != 2)
        {
            missing_int = 2;
        }
        else if (numbers[3] != 3)
        {
            missing_int = 3;
        }
        else if (numbers[4] != 4)
        {
            missing_int = 4;
        }
        else if (numbers[5] != 5)
        {
            missing_int = 5;
        }
        else if (numbers[6] != 6)
        {
            missing_int = 6;
        }
        else if (numbers[7] != 7)
        {
            missing_int = 7;
        }
        else if (numbers[8] != 8)
        {
            missing_int = 8;
        }
        else
        {
            missing_int = 9;
        }
        return missing_int;
    }

    // takes in the massive board and prints it right back with the correct formatting
    public static void print_all_boards(int num_boards, int[][] board){

        // determines how many times we need to iterate
        int k = num_boards * 9;

        // logic for printing all the numbers with correct formatting
        for (int i = 0; i < k; ++i)
        {
            for(int j = 0; j < 9; ++j)
            {
                System.out.print(board[i][j]);
                if (j != 8) 
                {
                    System.out.print(" ");
                } 
                if (j == 8 & i != 8)
                {
                    System.out.println();
                } 
                if (i == 8 & j == 8) 
                {
                    System.out.println("");
                }
            }
        }

        // adds the board of all zeros to the end, would be a waste to scan it in, so we just add it to the end
        int[][] zero_board = new int[9][9];

        for (int i = 0; i < 9; ++i)
        {
            for(int j = 0; j < 9; ++j) 
            {
                System.out.print(zero_board[i][j]);
                if (j != 8) 
                {
                    System.out.print(" ");
                } 
                if (j == 8 & i != 8) 
                {
                    System.out.println();
                } 
                if (i == 8 & j == 8) 
                {
                    System.out.println();
                }
            }
        }
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
