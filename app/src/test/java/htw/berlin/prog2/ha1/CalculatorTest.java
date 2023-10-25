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

  //------------------------------------------------------------------------------------
    //TODO hier weitere Tests erstellen
    // meine Arbeit s0582356
    @Test
    @DisplayName("Zwei positive Zahlen werden voneinander subtrahiert!")
    void testPositiveSubtraktion() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    // meine Arbeit s0582356 Inversion von 0 nicht möglich
    @Test
    @DisplayName("Die Inversion von 0 nicht möglich")
    public void testInverseOfZero() {
        // Neues Calculator-Objekt erstellen
        Calculator calculator = new Calculator();

        // Die Zahl "0" eingeben
        calculator.pressDigitKey(0);

        // Versuch, die Inversion zu berechnen
        calculator.pressUnaryOperationKey("1/x");

        // Das Ergebnis sollte "Error" sein, da die Inversion von 0 nicht definiert ist
        assertEquals("Error", calculator.readScreen());
    }
    // meine Arbeit s0582356
    @Test
    public void testSingleClearPress() {
        Calculator calculator = new Calculator();
        calculator.pressDigitKey(5);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(3);
        calculator.pressClearKey(); // Sollte nur den Bildschirm zurücksetzen
        calculator.pressDigitKey(2);
        calculator.pressEqualsKey();  // Das erwartete Ergebnis ist 5 + 2 = 7

        assertEquals("7", calculator.readScreen());
    }

    // meine Arbeit s0582356

    @Test
    public void testConsecutiveBinaryOperations() {
        Calculator calculator = new Calculator();
        calculator.pressDigitKey(5);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(3);
        calculator.pressBinaryOperationKey("-");
        calculator.pressDigitKey(2);
        calculator.pressEqualsKey();
        assertEquals("6", calculator.readScreen()); // Erwarte 5 + 3 - 2 = 6
    }



}

