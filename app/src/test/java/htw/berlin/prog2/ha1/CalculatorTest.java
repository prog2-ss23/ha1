package htw.berlin.prog2.ha1;

import org.checkerframework.common.value.qual.StaticallyExecutable;
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
    @DisplayName("should  allow multiple decimal dots")
    void testMultipleDecimalDotsminus() {
        Calculator calc = new Calculator();


        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressDotKey();
        calc.pressDigitKey(9);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "-7.98";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after subtrcting two positive multi-digit numbers")
    void testPositivesubs() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(1);
        calc.pressDigitKey(8);
        calc.pressEqualsKey();

        String expected = "62";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should display - result after dividing one negetive multi-digit numbers & take the ")
    void testPositivedev() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);

        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(1);
        calc.pressNegativeKey();
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "-6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should one negetive number subtract from a positive number")
    void testnegsub(){

        Calculator calc = new Calculator();
        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(9);
        calc.pressNegativeKey();
        calc.pressEqualsKey();

        String expected = "17";
        String actual = calc.readScreen();
         assertEquals(expected,actual);
    }


    @Test
    @DisplayName("using M+ and MR funktion memory adding(+) and memory recall")
    void AddingtoMemoryandrecallingit(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(9);
        calc.pressEqualsKey();
        calc.pressUnaryOperationKey("M+");
        calc.pressClearKey();
        calc.Memoryrecall();
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();


        String expected = "-3";
      String actual = calc.readScreen();
      assertEquals(expected,actual);
    }

    @Test
    @DisplayName("using M- and MR funktion memory adding(as -) and memory recall")
    void ADDINGtomemoryandrecallitasNEG(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(1);
        calc.pressDigitKey(1);
        calc.pressEqualsKey();
        calc.pressUnaryOperationKey("M-");
        calc.pressClearKey();
        calc.Memoryrecall();
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();


        String expected = "-2";
        String actual = calc.readScreen();
        assertEquals(expected,actual);

}
    @Test
    @DisplayName("should display result after subtrcting two positive multi-digit numbers")
    void testPositivesubs333() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(1);
        calc.pressDigitKey(8);
        calc.pressEqualsKey();
        calc.pressUnaryOperationKey("M+");
        calc.pressClearKey();
        calc.Memoryrecall();
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(9);
        calc.pressEqualsKey();
        calc.pressUnaryOperationKey("MC");
        calc.Memoryrecall();
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(9);
        calc.pressEqualsKey();


        String expected = "-9";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }



}


