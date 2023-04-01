import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class test_SchangKyleProj2 {

    @Test
    @DisplayName("Person 1")
    void person_one() {
        SchangKyleProj2.Person[] person = new SchangKyleProj2.Person[1];
        person[0] =  new SchangKyleProj2.Person("Schang, Kyle");
        assertEquals("Schang, Kyle", person[0].getName());
        System.out.println(person[0].getName());
    }

    @Test
    @DisplayName("Person 2")
    void person_two() {
        SchangKyleProj2.Person[] person = new SchangKyleProj2.Person[1];
        person[0] = new SchangKyleProj2.Student("Schang, Kyle", 1535291);
        assertEquals("Schang, Kyle", person[0].getName());
    }

}
