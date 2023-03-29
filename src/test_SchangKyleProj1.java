import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class test_SchangKyleProj1 {


    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Assertions Assert;
    int[][] test_answers = new int[3][3];


    @Test
    @DisplayName("One Missing")
    void one_missing(){
        SchangKyleProj1.board = new int[][] {{7,2,4,8,6,5,1,3,9},{5,1,9,2,4,3,8,7,6},{3,0,6,7,9,1,5,4,2},{1,7,8,6,2,9,4,5,3},{9,4,3,1,5,8,2,6,7},{6,5,2,3,7,4,9,1,8},{2,3,1,5,8,6,7,9,4},{8,9,5,4,3,7,6,2,1},{4,6,7,9,1,2,3,8,5}};
        test_answers = new int[][] {{2,1,8},{0,0,0},{0,0,0}};
        SchangKyleProj1.location = new int[][] {{2,1},{0,0},{0,0}};
        SchangKyleProj1.zeros = 1;
        SchangKyleProj1.solveBoard();
        for (int i = 0; i < 3; ++ i){
            for (int j = 0; j < 3; ++ j){
                assertEquals(test_answers[i][j], SchangKyleProj1.answers[i][j]);
            }
        }
    }


}
