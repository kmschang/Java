import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.*;

public class test_SchangKyleProj1 {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor =
      new ByteArrayOutputStream();
  private Assertions Assert;
  int[][] test_answers = new int[3][3];

  // {{},{},{},{},{},{},{},{},{}}

  @Test
  @DisplayName("(3,0,8)")
  void three_zero_eight() {
    SchangKyleProj1.board = new int[][] {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                                         {
                                             4,
                                             5,
                                             6,
                                             7,
                                             8,
                                             9,
                                             1,
                                             2,
                                             3,
                                         },
                                         {7, 8, 9, 1, 2, 3, 4, 5, 6},
                                         {0, 1, 2, 3, 4, 5, 6, 9, 7},
                                         {
                                             3,
                                             4,
                                             5,
                                             6,
                                             9,
                                             7,
                                             2,
                                             1,
                                             8,
                                         },
                                         {
                                             6,
                                             9,
                                             7,
                                             2,
                                             1,
                                             8,
                                             3,
                                             4,
                                             5,
                                         },
                                         {
                                             2,
                                             3,
                                             8,
                                             5,
                                             6,
                                             1,
                                             9,
                                             7,
                                             4,
                                         },
                                         {
                                             5,
                                             6,
                                             1,
                                             9,
                                             7,
                                             4,
                                             8,
                                             3,
                                             2,
                                         },
                                         {
                                             9,
                                             7,
                                             4,
                                             8,
                                             3,
                                             2,
                                             5,
                                             6,
                                             1,
                                         }};
    test_answers = new int[][] {{3, 0, 8}, {0, 0, 0}, {0, 0, 0}};
    SchangKyleProj1.location = new int[][] {{3, 0}, {0, 0}, {0, 0}};
    SchangKyleProj1.zeros = 1;
    SchangKyleProj1.solveBoard();
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        assertEquals(test_answers[i][j], SchangKyleProj1.answers[i][j]);
      }
    }
  }

  @Test
  @DisplayName("(8,8,9)")
  void eight_eight_nine() {
    SchangKyleProj1.board =
        new int[][] {{1, 2, 3, 4, 5, 6, 7, 9, 8}, {4, 5, 6, 7, 8, 9, 1, 2, 3},
                     {7, 8, 9, 1, 2, 3, 4, 5, 6}, {2, 1, 4, 3, 6, 5, 9, 8, 7},
                     {3, 6, 5, 8, 9, 7, 2, 1, 4}, {8, 9, 7, 2, 1, 4, 3, 6, 5},
                     {5, 3, 1, 9, 4, 8, 6, 7, 2}, {9, 4, 8, 6, 7, 2, 5, 3, 1},
                     {6, 7, 2, 5, 3, 1, 8, 4, 0}};
    test_answers = new int[][] {{8, 8, 9}, {0, 0, 0}, {0, 0, 0}};
    SchangKyleProj1.location = new int[][] {{8, 8}, {0, 0}, {0, 0}};
    SchangKyleProj1.zeros = 1;
    SchangKyleProj1.solveBoard();
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        assertEquals(test_answers[i][j], SchangKyleProj1.answers[i][j]);
      }
    }
  }
}
