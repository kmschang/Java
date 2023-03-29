import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class test_Exercise11_13 {

    @Test
    @DisplayName("Remove Duplicates")
    void test_removeDuplicate() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(210);
        list.add(1);
        list.add(6);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2);
        Exercise11_13.removeDuplicate(list);
        assertEquals(7, list.size());
    }


}