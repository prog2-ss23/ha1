package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {


    @Test
    @DisplayName("should put 0 as a latestvalue and solve the equation")
    void testWithoutLatestValue() {
        Calculator calc = new Calculator();


        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(7);
        calc.pressEqualsKey();


        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

