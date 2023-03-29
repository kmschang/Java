/*
Kyle Schang
EECS 1510
03-030-2023

First defined all the variables needed, to solve the board. Then I made the main method to solve it.
Checks for when zeros is larger than 4 and stops. I made two function for solving with one missing, one horizontal and the other vertical.
I made one method for when there are two missing, and it references the two other one missing ones.
The last function is based off what Hobbs put into blackboard. I watched his video a few times and I think I got it the way he wanted.

 */


// imports the scanner
import java.util.*;

// main class
public class SchangKyleProj1
{

    // All the variables I will need including row, column, zeros, board, and more.

    // board to keep track of the values
    static int[][] board = new int[9][9];

    // zeros to keep track of how many zeros there are
    static int zeros = 0;

    // row to keep track of where we are when we are going through teh board
    static int row = 0;

    // col to keep track of where we are when we are going through the board
    static int col = 0;

    // threebyrow used for type three to know the row
    static int threebyrow = 0;

    // threebycol used for type three to know the col
    static int threebycol = 0;

    // used to know the location of the zeros
    static int[][] location = new int[3][2];

    // used for the test case
    static int[][] answers = new int[3][3];

    // scanner used to take in the board from the user and put them into variables
    static Scanner scnr = new Scanner(System.in);


    // main function. Tried to minimize it as much as I could and make most of it modular
    public static void main(String[] args)
    {
        // does while zeros is less than 4. No need to check all the way up to 81 because after 3, we won't need to solve it.
        do
        {
            readBoard();
            // if there are zeros, it solves the board
            if (zeros <= 3) solveBoard();
        } while (zeros < 4);
        // prints the end statement to show that we are at the end of the program
        System.out.println("END");
    }

    // reads the board in and checks for zeros at the same time
    public static void readBoard()
    {
        // setting variables to zero so we can reuse them
        int loc = 0; zeros = 0;
        // nested for loop to scan in the board
        for (row = 0; row < 9; ++row)
        {
            for (col = 0; col < 9; ++col)
            {
                board[row][col] = scnr.nextInt();
                // checks to see if the one it just inputted was a zero, if it was, it stores the location for later.
                if (board[row][col] == 0)
                {
                    location[loc][0] = row;
                    location[loc][1] = col;
                    ++zeros;
                    if (loc < 2) ++loc;
                }
            }
            // breaks out of the loop if we have over 4 zeros
            if (zeros > 5) break;
        }
        // reset variables for next time
        row = 0; col = 0;
    }


    // used to find the zeros in the board.
    public static void find_zero()
    {
        // sets the variables back to zero so they can be used
        int loc = 0; zeros = 0;

        for (row = 0; row < 9; ++row){
            for (col = 0; col < 9; ++col)
            {
                if (board[row][col] == 0)
                {
                    location[loc][0] = row;
                    location[loc][1] = col;
                    ++zeros;
                    if (loc < 1) ++loc;
                }
            }
        }
    }



    // main function for solving the board. Check to see how many zeros there are and then points to the necessary function
    public static void solveBoard()
    {
        // one zero missing, solves with type one
        if (zeros == 1)
        {
            System.out.println("(" + location[0][0] + "," + location[0][1] + "," + typeOneH(location[0][0]) + ")");
            answers[0][0] = location[0][0]; answers[0][1] = location[0][1]; answers[0][2] = typeOneH(location[0][0]);
        }
        // two zeros missing, solves with type two zero
        if (zeros == 2)
        {
            System.out.print("(" + location[0][0] + "," + location[0][1] + "," + typeTwo()[0] + ")");
            System.out.println(" (" + location[1][0] + "," + location[1][1] + "," + typeTwo()[1] + ")");
            answers[0][0] = location[0][0]; answers[0][1] = location[0][1]; answers[0][2] = typeTwo()[0];
            answers[1][0] = location[1][0]; answers[1][1] = location[1][1]; answers[1][2] = typeTwo()[1];
        }
        // three zeros missing, solves with type three zero
        if (zeros == 3)
        {
            int answer1 = typeThree()[0];
            System.out.print("(" + threebyrow + "," + threebycol + "," + answer1 + ")");
            System.out.print(" (" + location[0][0] + "," + location[0][1] + "," + typeThree()[1] + ")");
            System.out.println(" (" + location[1][0] + "," + location[1][1] + "," + typeThree()[2] + ")");
        }
    }



    // method for solving one missing, checking horizontally
    public static int typeOneH(int answer)
    {
        int row_total = 0;
        for (int i = 0; i < 9; ++i)
        {
            row_total = row_total + board[answer][i];
        }
        return (45 - row_total);
    }

    // method for solving one missing, check vertically
    public static int typeOneV(int answer)
    {
        int col_total = 0;
        for (int i = 0; i < 9; ++ i)
        {
            col_total = col_total + board[i][answer];
        }
        return (45 - col_total);
    }

    // method for solving two missing, uses typeOne in typeTwo to solve them individually
    public static int[] typeTwo()
    {
        boolean horizontal = false;
        int[] answers = new int[2];
        if (location[0][0] != location[1][0]) horizontal = true;
        if (horizontal)
        {
            answers[0] = typeOneH(location[0][0]);
            answers[1] = typeOneH(location[1][0]);
        }
        else
        {
            answers[0] = typeOneV(location[0][1]);
            answers[1] = typeOneV(location[1][1]);
        }
        return answers;
    }

    // method for solving three missing, uses typeOne and typeTwo to solve
    public static int[] typeThree()
    {
        // initializing new variables to keep track of all the arrays to find the zeros and values
        int[] answers = new int[3];
        int[][] threeByCounts = new int[9][3];
        int whichBox;
        // used so we can later see which boxes are alone so we can solve it easier
        for (int r = 0; r < 9; ++ r)
        {
            for (int c = 0; c < 9; ++ c)
            {
                if (board[r][c] == 0)
                {
                    whichBox = ((r/3)*3 + (c/3));
                    threeByCounts[whichBox][0] ++;
                    threeByCounts[whichBox][1] = r;
                    threeByCounts[whichBox][2] = c;
                }
            }
        }
        // used to find which box is also so we can solve it easier
        for (int i = 0; i < 9; ++i)
        {
            if (threeByCounts[i][0] == 1)
            {
                board[threeByCounts[i][1]][threeByCounts[i][2]] = answers[0];
                threebyrow = threeByCounts[i][1];
                threebycol = threeByCounts[i][2];
            }
        }
        // the final functions to find the missing values
        // we found the first one with the whichbox and threebycounts but now it is the time to find the other two
        // to find the other two, we just used the typeTwo function


        // if (location[0][0] == location[1][0])

    }



}
