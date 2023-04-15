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
    //Teilaufgabe 1
    @Test
    @DisplayName("should display result after dividing two positive decimal numbers")
    void testDividingDecimalNumbers(){
        Calculator calc = new Calculator(); //Instanz der Calculator-Klasse

        calc.pressDigitKey(5);             //Ziffer 5
        calc.pressDotKey();                //Dezimaltrennzeichentaste
        calc.pressDigitKey(0);             //Ziffer 0
        calc.pressBinaryOperationKey("/"); //dividieren
        calc.pressDigitKey(2);             //Ziffer 2
        calc.pressDotKey();                //Dezimaltrennzeichentaste
        calc.pressDigitKey(5);             //Ziffer 5
        calc.pressEqualsKey();             //Gleichheitstaste

        String expected = "2";             //Erwartungswert 2 in Variable "expected" speichern
        String actual = calc.readScreen(); //Wert des Taschenrechners auslesen und in Variable "actual" speichern

        assertEquals(expected, actual);    //Erwartetes Ergebnis mit tatsächlichem Ergebnis vergleichen
    }

    //Teilaufgabe 2 (erster Test)
    @Test
    @DisplayName("should display error for inversion of zero")
    void testInversionOfZero() {
        Calculator calc = new Calculator(); //Instanz der Calculator-Klasse

        calc.pressDigitKey(0);              //Ziffer 0
        calc.pressUnaryOperationKey("1/x"); //Versuche Inversion von 0 durchzuführen

        String expected = "Error";          //Error als Erwartungswert
        String actual = calc.readScreen();  //Wert des Taschenrechners auslesen und in Variable "actual" speichern

        assertEquals(expected, actual);     //Erwartetes Ergebnis mit tatsächlichem Ergebnis vergleichen
    }

}

