import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class test_SimpleMath {

  @Test
  @DisplayName("Multiplication")
  void test_multiply() {
    assertEquals(10, multiply.product(2, 5));
    assertEquals(210, multiply.product(5, 6, 7));
  }

  @Test
  @DisplayName("Addition")
  void test_addition() {
    assertEquals(10, addition.add(5, 5));
  }

  @Test
  @DisplayName("Subtraction")
  void test_subtraction() {
    assertEquals(10, subtraction.subtract(20, 10));
  }

  @Test
  @DisplayName("Division")
  void test_division() throws InvalidDivision {
    assertEquals(10, division.divide(100, 10));
  }
}
