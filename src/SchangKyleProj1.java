import java.util.*;

public class SchangKyleProj1 {


    static int[][] board = new int[9][9];
    static int zeros = 0;
    static int row = 0;
    static int col = 0;
    static int threebyrow = 0;
    static int threebycol = 0;
    static int[][] location = new int[3][2];
    static Scanner scnr = new Scanner(System.in);


    public static void main(String[] args){

        do {
            readBoard();
            if (zeros <= 3) solveBoard();
        } while (zeros < 4);
        System.out.println("END");

    }


    public static void readBoard(){
        int loc = 0; zeros = 0;
        for (row = 0; row < 9; ++row){
            for (col = 0; col < 9; ++ col){
                board[row][col] = scnr.nextInt();
                if (board[row][col] == 0){
                    location[loc][0] = row;
                    location[loc][1] = col;
                    ++ zeros;
                    if (loc < 2) ++loc;
                }
            }
            if (zeros > 5) break;
        }
        row = 0; col = 0;
    }



    public static void find_zero(){
        int loc = 0; zeros = 0;
        for (row = 0; row < 9; ++row){
            for (col = 0; col < 9; ++ col){
                if (board[row][col] == 0){
                    location[loc][0] = row;
                    location[loc][1] = col;
                    ++ zeros;
                    if (loc < 1) ++ loc;
                }
            }
        }
        location[2][0] = 0; location[2][1] = 0;
    }




    public static void solveBoard(){
        if (zeros == 1){
            System.out.println("(" + location[0][0] + "," + location[0][1] + "," + typeOneH(location[0][0]) + ")");
        }
        if (zeros == 2){
            System.out.print("(" + location[0][0] + "," + location[0][1] + "," + typeTwo()[0] + ")");
            System.out.println(" (" + location[1][0] + "," + location[1][1] + "," + typeTwo()[1] + ")");
        }
        if (zeros == 3){
            int answer1 = typeThree()[0];
            System.out.print("(" + threebyrow + "," + threebycol + "," + answer1 + ")");
            System.out.print(" (" + location[0][0] + "," + location[0][1] + "," + typeThree()[1] + ")");
            System.out.println(" (" + location[1][0] + "," + location[1][1] + "," + typeThree()[2] + ")");
        }
    }




    public static int typeOneH(int answer){
        int row_total = 0;
        for (int i = 0; i < 9; ++i){
            row_total = row_total + board[answer][i];
        }
        return (45 - row_total);
    }

    public static int typeOneV(int answer){
        int col_total = 0;
        for (int i = 0; i < 9; ++ i){
            col_total = col_total + board[i][answer];
        }
        return (45 - col_total);
    }


    public static int[] typeTwo(){
        boolean horizontal = false;
        int[] answers = new int[2];
        if (location[0][0] != location[1][0]) horizontal = true;
        if (horizontal){
            answers[0] = typeOneH(location[0][0]);
            answers[1] = typeOneH(location[1][0]);
        } else {
            answers[0] = typeOneV(location[0][1]);
            answers[1] = typeOneV(location[1][1]);
        }
        return answers;
    }

    public static int[] typeThree(){
        int[] answers = new int[3];
        int[][] threeByCounts = new int[9][3];
        int whichBox = 0;

        for (int r = 0; r < 9; ++ r){
            for (int c = 0; c < 9; ++ c){
                if (board[r][c] == 0){
                    whichBox = ((r/3)*3 + (c/3));
                    threeByCounts[whichBox][0] ++;
                    threeByCounts[whichBox][1] = r;
                    threeByCounts[whichBox][2] = c;
                }
            }
        }

        for (int i = 0; i < 9; ++i){
            if (threeByCounts[i][0] == 1){
                answers[0] = typeOneH(threeByCounts[i][1]);
                board[threeByCounts[i][1]][threeByCounts[i][2]] = answers[0];
                threebyrow = threeByCounts[i][1];
                threebycol = threeByCounts[i][2];
            }
        }

        find_zero();
        answers[1] = typeTwo()[0];
        answers[2] = typeTwo()[1];
        return answers;
    }



}
