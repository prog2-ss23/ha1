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
//todo
//grüner test
    @Test
    @DisplayName("should display result after subtract two positive multi-digit numbers")
    void testPositivSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(1);
        calc.pressDigitKey(1);
        calc.pressEqualsKey();

        String expected = "5";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    /*//roter test
    @Test
    @DisplayName("should not allow subtrac or adding bevor divided or multiply two positive numbers")
    void testPointBevorLine() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "13.5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

     */


    //roter test
    // Idee mit Mera Gebreyes
    /*@Test
    @DisplayName("should equal zero if no didgit pressd ")
    void testNoDigit() {
        Calculator calc = new Calculator();
        calc.pressBinaryOperationKey("X");
        calc.pressEqualsKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

     */


    //roter test
    /*@Test
    @DisplayName("should memory numbers")
    void testMemory() {
        Calculator calc = new Calculator();

        calc.pressMemoryKey(M+);
        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("X");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();
        calc.pressMemoryKey(M+);

        String expected = "8";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

     */
    //roter test
    //Idee mit Mera Gebreyes und Klaudia Puchaczewski
    @Test
    @DisplayName("should display result after getting the square root of 9")
    void testSquareRootNine() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressUnaryOperationKey("√");

        String expected = "3";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //roter test
    //Idee Klaudia Puchaczewski
    @Test
    @DisplayName("should display error when fraktion by zero")
    void testFraktionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("1/x");


        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}


