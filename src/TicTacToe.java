import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TicTacToe {

  public static char[][] board = new char[3][3];
  public static Character player_char;
  public static int player_num;
  public static Character computer_char;
  static Scanner scnr = new Scanner(System.in);
  public static int move = 1;

  public static void main(String[] args) {
    loading();
    set_chars();
    move();
  }

  public static void clear(int lines) {
    String blank_line = "\n";
    System.out.print(blank_line.repeat(lines));
  }

  public static void loading() {

    clear(100);
    title();
    System.out.println("\u001B[34m");
    System.out.println("              Created by Kyle Schang");
    System.out.print("\u001B[37m");
    System.out.println();

    int loading_number = 0;

    System.out.print("                     \u001B[31mLoading");
    System.out.print("\u001B[37m\n           [");

    do {
      try {
        TimeUnit.MILLISECONDS.sleep(25);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.print("\u001B[31m#");
      ++loading_number;
    } while (loading_number < 25);

    System.out.print("\u001B[37m]");
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println();
    System.out.println();

    clear(100);
  }

  public static void title() {
    System.out.print("\u001B[31m");
    System.out.println(
        "_____    ____   _____   _    ____   _____  ____  ___         ");
    System.out.println(
        "  |   |  |        |    /_\\   |        |    |  |  |__       ");
    System.out.println(
        "  |   |  |___     |   /   \\  |___     |    |__|  |__         ");
    System.out.println("\u001B[37m");
  }

  public static void starting_board() {
    title();
    System.out.println("\n");
    int spot = 1;
    for (int row = 0; row < 3; ++row) {
      for (int col = 0; col < 3; ++col) {
        if (col == 0) {
          System.out.print("                   ");
        }
        if (col != 2) {
          System.out.print(" "
                           + "\u001B[31m" + spot + "\u001B[37m"
                           + " |");
        }
        if (col == 2) {
          System.out.print(" "
                           + "\u001B[31m" + spot + "\u001B[37m");
        }
        if (row != 2 & col == 2) {
          System.out.println("\n                   -----------");
        }
        if (row == 2 & col == 2)
          System.out.println();
        ++spot;
      }
    }
  }

  public static Character pick_char() {
    System.out.println();
    System.out.println();
    try {
      System.out.println(
          "Do you want to be \u001B[31m'X'\u001B[37m or \u001B[31m'O'\u001B[37m");
      char choice = scnr.next().charAt(0);
      if (choice == 'X' || choice == 'x' || choice == 'O' || choice == 'o') {
        if (toUpperCase(choice) == 'X') {
          player_num = 1;
        } else {
          player_num = 2;
        }
        return choice;
      } else {
        throw new notCharException(choice);
      }
    } catch (notCharException e) {
      e.print();
      return pick_char();
    }
  }

  public static void set_chars() {

    starting_board();

    char player = toUpperCase(pick_char());
    player_char = player;

    if (player == 'X') {
      computer_char = 'O';
    } else {
      computer_char = 'X';
    }

    System.out.println("You are now \u001B[33m" + player_char + "\u001B[37m");

    board = new char[][] {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    display_board();
  }

  public static void display_board() {

    clear(100);
    title();
    System.out.println();

    System.out.println("\u001B[37m         Player is \u001B[33m" + player_char +
                       "\u001B[37m         Computer is \u001B[36m" +
                       computer_char + "\u001B[37m");

    System.out.println();

    for (int row = 0; row < 3; ++row) {
      for (int col = 0; col < 3; ++col) {
        if (col == 0) {
          System.out.print("                    ");
        }
        if (board[row][col] == toUpperCase(player_char)) {
          System.out.print("\u001B[33m" + board[row][col] + "\u001B[37m");
        } else {
          System.out.print("\u001B[36m" + board[row][col] + "\u001B[37m");
        }
        if (col != 2) {
          System.out.print(" | ");
        }
        if (row != 2 & col == 2) {
          System.out.println("\n                   -----------");
        }
        if (row == 2 & col == 2) {
          System.out.println();
        }
      }
    }
  }

  public static void move() {

    // player gets odd moves, player starts
    if (player_num % 2 == move % 2) {
      choose_location();
      display_board();
    }
    // player gets even moves, computer starts
    else if (player_num % 2 != move % 2) {
      computer_random_move();
      display_board();
    }

    if (check_for_win(player_char)) {
      System.out.println("Player won");
    } else if (check_for_win(computer_char)) {
      System.out.println("Computer won");
    } else {
      move();
    }
  }

  public static void computer_random_move() {
    int row;
    int col;
    int first_index = (int)Math.floor(Math.random() * (9 - 1 + 1) + 1);

    if (first_index == 1) {
      row = 0;
      col = 0;
    } else if (first_index == 2) {
      row = 0;
      col = 1;
    } else if (first_index == 3) {
      row = 0;
      col = 2;
    } else if (first_index == 4) {
      row = 1;
      col = 0;
    } else if (first_index == 5) {
      row = 1;
      col = 1;
    } else if (first_index == 6) {
      row = 1;
      col = 2;
    } else if (first_index == 7) {
      row = 2;
      col = 0;
    } else if (first_index == 8) {
      row = 2;
      col = 1;
    } else {
      row = 2;
      col = 2;
    }

    if (check_location(row, col)) {
      board[row][col] = computer_char;
      ++move;
    } else {
      computer_random_move();
    }
  }

  public static boolean check_location(int row, int col) {

    return board[row][col] != 'X' && board[row][col] != 'O';
  }

  public static void choose_location() {

    System.out.println("\n    Where would like to place the next " +
                       player_char + "? (1-9)");
    int location = scnr.nextInt();

    int row;
    int col;

    if (location == 1) {
      row = 0;
      col = 0;
    } else if (location == 2) {
      row = 0;
      col = 1;
    } else if (location == 3) {
      row = 0;
      col = 2;
    } else if (location == 4) {
      row = 1;
      col = 0;
    } else if (location == 5) {
      row = 1;
      col = 1;
    } else if (location == 6) {
      row = 1;
      col = 2;
    } else if (location == 7) {
      row = 2;
      col = 0;
    } else if (location == 8) {
      row = 2;
      col = 1;
    } else {
      row = 2;
      col = 2;
    }

    if (check_location(row, col)) {
      board[row][col] = player_char;
      ++move;
    } else {
      System.out.println("There is already a move there. Play somewhere else.");
      choose_location();
    }
  }

  public static boolean check_for_win(char letter) {

    // Checking horizontal
    for (int row = 0; row < 3; ++row) {
      int count = 0;
      for (int col = 0; col < 3; ++col) {
        if (board[row][col] == letter) {
          ++count;
        }
      }
      if (count == 3) {
        return true;
      }
    }

    // Checking Vertical
    for (int row = 0; row < 3; ++row) {
      int count = 0;
      for (int col = 0; col < 3; ++col) {
        if (board[col][row] == letter) {
          ++count;
        }
      }
      if (count == 3) {
        return true;
      }
    }

    // Checking upper left diagonal
    int count = 0;
    for (int row = 0; row < 3; ++row) {
      if (board[row][row] == letter) {
        ++count;
      }
      if (count == 3) {
        return true;
      }
    }

    // Checking upper right diagonal
    count = 0;
    for (int row = 0; row < 3; ++row) {
      if (board[row][2 - row] == letter) {
        ++count;
      }
      if (count == 3) {
        return true;
      }
    }

    return false;
  }

  public static boolean computer_block() { return false; }

  public static boolean computer_win() { return false; }

  public static void x_won() {}

  public static void o_won() {}

  public static void tie() {}
}

class notCharException extends Exception {

  Character choice;
  notCharException(Character choice) { this.choice = choice; }

  void print() {
    System.out.println(
        choice +
        " is not a choice. Please pick only \u001B[31m'X'\u001B[37m or \u001B[31m'O'\u001B[37m.");
  }
}
