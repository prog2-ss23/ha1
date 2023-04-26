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

    //green test
    @Test
    @DisplayName("should display result after multiplying two numbers")
    void testMultiplication() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(4);
        calc.pressEqualsKey();

        String expected = "8";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //green test
    @Test
    @DisplayName("should display Error after a division by zero")
    void testDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //green test
    @Test
    @DisplayName("should display zero after pressing the clear button")
    void testClearKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressClearKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //green test
    @Test
    @DisplayName("")
    void testUnaryOperationKeyProzent() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressUnaryOperationKey("%");

        String expected = "0.04";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //green test
    @Test
    @DisplayName("")
    void testUnaryOperationKeyInversion() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.11111111";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // green test
    @Test
    @DisplayName("")
    void testMultiplicationWithZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //red test
    @Test
    @DisplayName("should display '-' before the first number")
    void testMinus() {
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        calc.pressDigitKey(9);

        String expected = "-9";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // red test
    @Test
    @DisplayName("should be able to add two negative numbers correctly")
    void testAdditionUsingNegativeNumbers() {
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "-1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

