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
        //given: wir haben calculator calc
        Calculator calc = new Calculator();

        //when: funktionalität, wenn ich das drücke
        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        //then: dann erwarte ich das...
        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //jede Teilaufgabe mindestens 1 Commit!
    //TODO hier weitere Tests erstellen

    @Test
    //Aufgabe 1
    void testSubtraction(){
        //given
        Calculator calc = new Calculator();

        //when
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(4);
        calc.pressEqualsKey();

        //then
        String expected = "6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    //Aufgabe 2
    //[+/-] Button
    void testPressNegativeKey(){
        //given
        Calculator calc = new Calculator();

        //when
        calc.pressNegativeKey();
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);

        //then
        String expected = "-10";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

