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
    /**
     *
     * Der Testfall deckt die Multiplikation zweier positiver Zahlen ab.
     * Ich möchte darauf hinweisen, dass dieser und alle weitern Tests in Zusammenarbeit mit Jim Langecker geschehen,
     * dem die Matrikelnr. S0587485 vergeben wurde.
     *
     */

    @Test
    @DisplayName("should display result after the multiplication of two positive numbers.")
    void testMultiplication() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "25";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    /**Aufgabe 2:
     * Getestet wird das Löschen des Zwischenspeichers. Werden zwei Zahlen und ein Rechnenoperand eingegeben, soll die zweite Zahl jedoch
     * gelöscht (clear) und neu eingegeben werden, so prüft dieser Test den Löschvorgang.
     * @Author Finn Wölk, Jim Langecker
     */
    //TODO hier weitere Tests erstellen
    @Test
    @DisplayName("should clear second entry and keeps first.")
    void TestClear() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(5);
        calc.pressClearKey();
        calc.pressDigitKey(9);
        calc.pressEqualsKey();

        String expected = "27";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    /**Aufgabe 2:
     * Getestet wird das Kürzen von Zahlen, mit mehr als 11 Ziffern.
     * @Author Finn Wölk, Jim Langecker
     */
    @Test
    @DisplayName("should display number with 9 digits.")
    void TestInversion() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.33333333";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /**
     * Bugfixes: Um den Test "TestInversion" zu fixen, musste in der Methode "pressUnaryOperationKey", in der zweiten If-Anweisung,
     * die Zahl, mit welcher screen.length verglichen wird, auf 9 heruntergesetzt werden
     */

}

