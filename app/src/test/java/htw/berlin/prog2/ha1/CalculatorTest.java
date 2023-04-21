package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("should devide decimal numbers and return correct result")
    void shouldDevideDecimalNumber() {
        //given
        Calculator calc = new Calculator();

        //when
        calc.pressDigitKey(4);
        calc.pressDotKey();
        calc.pressDigitKey(8);
        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        //then
        String erwartet = "2.445";
        String ist = calc.readScreen();

        assertEquals(erwartet, ist);
    }

    @Test
    @DisplayName("additional test, intended to add large numbers and return the correct result")
    void shouldAddLargeNumbers() {
        // given
        Calculator calc = new Calculator();

        //when
        calc.pressDigitKey(9);
        calc.pressDigitKey(2);
        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(7);
        calc.pressDigitKey(3);
        calc.pressDigitKey(7);
        calc.pressDigitKey(4);
        calc.pressDigitKey(9);
        calc.pressEqualsKey();

        //then
        String erwartet = "74677";
        String ist = calc.readScreen();

        assertEquals(erwartet, ist);
    }

    @Test
    @DisplayName("should return a result if there is only one input and no binary operations key is used")
    void shouldReturnResultWithoutBinaryOperationsKey() {

        // given
        Calculator calc = new Calculator();

        //when
        calc.pressDigitKey(7);
        calc.pressEqualsKey();

        //then
        String erwartet = "7";
        String ist = calc.readScreen();

        assertEquals(erwartet, ist);
    }


    //Calculate with unary operations
    @Test
    @DisplayName("should extract the square root and return the correct result")
    void shouldExtractTheSquareRoot() {

        // given
        Calculator calc = new Calculator();

        //when
        calc.pressDigitKey(8);
        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("√");
        calc.pressEqualsKey();

        //then
        String erwartet = "9";
        String ist = calc.readScreen();

        assertEquals(erwartet, ist);
    }

    @Test
    @DisplayName("should devide two decimal numbers and return remainder")
    void shouldCalculateWithModulo() {

        // given
        Calculator calc = new Calculator();

        //when
        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("%");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        //then
        String erwartet = "2";
        String ist = calc.readScreen();

        assertEquals(erwartet, ist);
    }

    @Test
    @DisplayName("should calculate the inversion and return the correct result")
    void shouldCalculateWithInversion() {

        // given
        Calculator calc = new Calculator();

        //when
        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("1/x");
        calc.pressEqualsKey();

        //then
        String erwartet = "0.11111111";
        String ist = calc.readScreen();

        assertEquals(erwartet, ist);
    }
}
