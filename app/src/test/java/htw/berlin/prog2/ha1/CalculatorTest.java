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

    //test which tests if screen equals 0 if C is pressed
    @Test
    @DisplayName("should clear screen")

    void testClearKey(){
      Calculator calc = new Calculator();
      calc.pressDigitKey(1);
      calc.pressBinaryOperationKey("+");
      calc.pressDigitKey(1);
      calc.pressEqualsKey();
      calc.pressClearKey();
      String expected="0";
      String actual=calc.readScreen();
      assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test double click of Binary Operations")

    void TestDoubleClickBinaryOperationKey(){
        Calculator calc=new Calculator();
        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("/");
        String expected="4";
        String actual=calc.readScreen();
        assertEquals(expected,actual);
    }


    @Test
    @DisplayName("Test binary operations")

    void TestBinaryOperations(){
        Calculator calc=new Calculator();
        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        String expected="2";
        String actual=calc.readScreen();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test result of square root result when result should have no decimals")

    void TestUnaryOperations(){
        Calculator calc=new Calculator();
        calc.pressDigitKey(4);
        calc.pressUnaryOperationKey("√");
        String expected="2";
        String actual=calc.readScreen();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test another click of = after some operation has been made")

    void TestBinaryOperationsAgain(){
        Calculator calc=new Calculator();
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(1);
        calc.pressEqualsKey();
        calc.pressEqualsKey();
        String expected="4";
        String actual=calc.readScreen();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test Negative key")

    void TestNegativeKeyPress(){
        Calculator calc=new Calculator();
        calc.pressNegativeKey();
        calc.pressDigitKey(6);
        String expected="-6";
        String actual=calc.readScreen();
        assertEquals(expected,actual);
    }





}

