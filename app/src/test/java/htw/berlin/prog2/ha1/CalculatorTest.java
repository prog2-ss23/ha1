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
    @DisplayName("should display result after dividing 2 Numbers 16 by 2  ")
    void testdividing (){

        Calculator calc= new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected="8";
        String actual= calc.readScreen();

        assertEquals(expected, actual);

    }


    @Test
    // test 1: 3 ads
    @DisplayName("should display result after adding 2 number and then add another number ")
    void testAddThreeNumbers (){

        Calculator calc= new Calculator();
                                   // screen = "0"
        calc.pressDigitKey(2);     // screen = "02"
        calc.pressDigitKey(0);     // screen = "020"
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);     // screen = "3"
        calc.pressDigitKey(0);     // screen = "30"
        calc.pressBinaryOperationKey("+");    // screen = "50", latest  = 50.0
        calc.pressDigitKey(3);
        calc.pressDigitKey(0);


        calc.pressEqualsKey();

        String expected="80";
        String actual= calc.readScreen();

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("should display result 2,5 after adding fractions")
    void testAddingFractions() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);

        calc.pressEqualsKey();

        String expected = "2.5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

