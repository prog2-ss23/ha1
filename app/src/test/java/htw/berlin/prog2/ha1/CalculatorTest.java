//@author Mojeeb Al-Hazmi, Ibrahim Danisman
// wir haben zusammen gearbeitet(gegenseitig geholfen)
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
        @DisplayName("sollte das Ergebnis einer Subtraktion von zweistelligen Zahlen anzeigen")
        void testPositiveSubtraction() {
            Calculator calc = new Calculator();

            calc.pressDigitKey(2);
            calc.pressDigitKey(0);
            calc.pressBinaryOperationKey("-");
            calc.pressDigitKey(1);
            calc.pressDigitKey(0);
            calc.pressEqualsKey();

            String expected = "10";
            String actual = calc.readScreen();

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("zeigt Error an, wenn man ohne vorherige Eingabe auf die Kehrwert-Taste drückt")
        void testDivisionByZeroByClickingOnTheReciprocalKey() {
            Calculator calc = new Calculator();

            calc.pressUnaryOperationKey("1/x");


            String expected = "Error";
            String actual = calc.readScreen();

            assertEquals(expected, actual);
        }
        //bug gefixt unter der Methode pressUnaryOperationKey()
        @Test
        @DisplayName("zieht die Wurzel aus einer negativen Kommazahl")
        void wurzelZiehen() {
            Calculator calc = new Calculator();

            calc.pressNegativeKey();
            calc.pressDigitKey(6);
            calc.pressDotKey();
            calc.pressDigitKey(3);
            calc.pressUnaryOperationKey("√");

            String expected = "Error";
            String actual = calc.readScreen();

            assertEquals(expected, actual);
        }
        // bug gefixt unter der Methode pressDigitKey()

}

