package hei.prog.app.service;

import static org.junit.jupiter.api.Assertions.*;

import hei.prog.app.exception.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ArithService tests")
class ArithServiceTest {
  private final ArithService arithService = new ArithService();

  @Test
  @DisplayName("add two positive numbers")
  void add_positive_numbers() {

    Double result = arithService.add(10.0, 3.0);

    assertEquals(13.0, result);
  }

  @Test
  @DisplayName("add two negative numbers")
  void add_negative_numbers() {

    Double result = arithService.add(-5.0, -3.0);

    assertEquals(-8.0, result);
  }

  @Test
  @DisplayName("add positive and negative numbers")
  void add_positive_and_negative_numbers() {

    Double result = arithService.add(10.0, -3.0);

    assertEquals(7.0, result);
  }

  @Test
  @DisplayName("subtract positive numbers")
  void sub_positive_numbers() {

    Double result = arithService.sub(10.0, 4.0);

    assertEquals(6.0, result);
  }

  @Test
  @DisplayName("multiply positive and negative numbers")
  void mul_positive_and_negative_numbers() {

    Double result = arithService.mul(2.0, -3.0);

    assertEquals(-6.0, result);
  }

  @Test
  @DisplayName("divide positive numbers")
  void div_positive_numbers() {

    Double result = arithService.div(28.0, 2.0);

    assertEquals(14.0, result);
  }

  @Test
  @DisplayName("divide negative numbers")
  void div_negative_numbers() {

    Double result = arithService.div(-8.0, -2.0);

    assertEquals(4.0, result);
  }

  @Test
  @DisplayName("throw exception when dividing by zero")
  void div_by_zero_should_throw_exception() {

    assertThrows(BadRequestException.class, () -> arithService.div(5.0, 0.0));
  }

  @Test
  @DisplayName("throw exception when first parameter is null")
  void first_parameter_null_should_throw_exception() {

    assertThrows(BadRequestException.class, () -> arithService.add(null, 5.0));
  }

  @Test
  @DisplayName("throw exception when second parameter is null")
  void second_parameter_null_should_throw_exception() {

    assertThrows(BadRequestException.class, () -> arithService.add(5.0, null));
  }
}
