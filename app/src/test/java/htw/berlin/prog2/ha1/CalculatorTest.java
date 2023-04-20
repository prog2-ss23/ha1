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


    //Positiver Test 1

    @Test
    @DisplayName("should display result after entering decimal numbers")
    void testDecimalNumber() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(5);

        String expected = "2.5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Positiver Test 2

    @Test
    @DisplayName("should display result after sign inversion")
    void testSignInversionPositive() {
        Calculator calc = new Calculator();

        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();
        calc.pressNegativeKey();

        String expected = "5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
    Negativer Test 1
    Tatsächliches Test-Ergebnis ist: 0.01333333 -> es müsste 1.33333333
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("1/x");

        String expected = "1.33333333";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
    Negativer Test 1.1
    Tatsächliches Test-Ergebnis ist: 0.2 -> es müsste 2
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal1() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("1/x");

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
    Negativer Test 1.2
    Tatsächliches Test-Ergebnis ist: 0.04 -> es müsste 4
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal2() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("1/x");

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

     /*
    Negativer Test 1.3
    Tatsächliches Test-Ergebnis ist: 0.04 -> es müsste 5
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal3() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("1/x");

        String expected = "5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

      /*
    Negativer Test 1.4
    Tatsächliches Test-Ergebnis ist: 0.04 -> es müsste 5
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal4() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("1/x");

        String expected = "5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
    Negativer Test 1.5
    Tatsächliches Test-Ergebnis ist: 0.04 -> es müsste 4
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal5() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressDigitKey(5);
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("1/x");

        String expected = "3.91256863";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

     /*
    Negativer Test 1.6
    Test bei einstelliger ganzer Zahl korrekt
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal6() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
    Negativer Test 1.7
    Test bei zweistelliger ganzer Zahl korrekt
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal7() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.04";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
    Negativer Test 1.8
    Test bei dreistelliger ganzer Zahl korrekt
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal8() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(5);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.004";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
    Negativer Test 1.9
    Test bei einstelliger Dezimalzahl >1 korrekt
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal9() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

      /*
    Negativer Test 1.10
    Test bei zweistelliger Dezimalzahl >1 korrekt
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal10() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.39215686";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

     /*
    Negativer Test 1.11
    Test bei dreistelliger Dezimalzahl >1 korrekt
     */

    @Test
    @DisplayName("should display reciprocal after reciprocal key")
    void testReciprocal11() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressDigitKey(5);
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.39138943";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}


