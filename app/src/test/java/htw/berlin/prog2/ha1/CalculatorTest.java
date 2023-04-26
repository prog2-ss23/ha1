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

    /*
            TODO: FIX FAILED CASE!
     */
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
     /*
            TODO: FIX FAILED CASE!
     */

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

    /**
     * TEST THAT PASSES
     */
    @Test
    @DisplayName("should display zero after pressing clear key once")
    void testClearKeyOnce(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressClearKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /**
     * TWO TESTS THAT FAIL
     */
    @Test
    @DisplayName("should save latest value after pressing clear key")
    void testLatestValue(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressClearKey();
        calc.pressDigitKey(8);
        calc.pressEqualsKey();

        String expected = "1";
        String actual = calc.readScreen();


        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should replace -0 with new number while still being negative")
    void testReplaceNumber(){
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        calc.pressDigitKey(6);
        calc.pressDigitKey(8);
        calc.pressEqualsKey();

        String expected = "-68";
        String actual = calc.readScreen();


        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should do nothing if just using equals key")
    void testJustEqualsKey(){
        Calculator calc = new Calculator();

        calc.pressEqualsKey();

        String expected = "0";
        String actual = calc.readScreen();


        assertEquals(expected, actual);
    }

}

