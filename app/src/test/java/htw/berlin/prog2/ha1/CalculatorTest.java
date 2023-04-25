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
    @Test
    @DisplayName("should not allow multiple decimal dots")
    public void testPressDotKey() {
        Calculator calculator = new Calculator();

        // Test adding decimal point to screen
        calculator.pressDigitKey(1);
        calculator.pressDigitKey(2);
        calculator.pressDotKey();
        String result = calculator.readScreen();
        assertEquals("12.", result);
    }

    @Test
    @DisplayName("Test if the pressClearKey Function actually works")
    public void testPressClearKey() {
        Calculator calculator = new Calculator();
        calculator.pressDigitKey(5);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(3);
        calculator.pressClearKey();
        assertEquals("0", calculator.readScreen());
    }
    @Test
    @DisplayName("should show Error if 1/X is pressed without a Number")
    void test_1DividedXWithoutNumber() {
        Calculator calculator = new Calculator();
        calculator.pressUnaryOperationKey("1/x");
        String expected = "Error";
        String actual = calculator.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should the complete sum of all operations")
    void doubleBinaryOperand() {

        Calculator calculator = new Calculator();
        calculator.pressDigitKey(1);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(1);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(1);
        calculator.pressBinaryOperationKey("+");
        calculator.pressEqualsKey();
        String expected = "3";
        String actual = calculator.readScreen();

        assertEquals(expected, actual);
    }






    //TODO hier weitere Tests erstellen
}

