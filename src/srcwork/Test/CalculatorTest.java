package Test;

import org.junit.Test;

import static Test.Calculator.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        String result = add("3", "2");  // In quaternary system
        assertEquals("11", result);  // Expecting "22" as the result in quaternary system
    }

    @Test
    public void testSubtract() {
        String result = subtract("13", "3");  // Subtraction in quaternary
        assertEquals("10", result);  // Expecting "10" as result
    }

    @Test
    public void testMultiply() {
        String result = multiply("2", "2");
        assertEquals("10", result);  // Expecting "10" in quaternary
    }

    @Test
    public void testDivide() {
        String result = Calculator.divide("10", "2");
        assertEquals("2", result);  // Expecting "2" in quaternary
    }

    @Test
    public void testQuaternaryToDecimal() {
        String result = Calculator.quaternaryToDecimal("12");
        assertEquals("6", result);  // "10" in quaternary equals "4" in decimal
    }

    @Test
    public void testDivideByZero(){
        String result = Calculator.divide("12","0");
        assertNotEquals("0", result);
    }

        public static void main(String[] args) {

        System.out.println("Add two numbers 10 + 3 :" + add( "10", "3"));
        //test add

        System.out.println("Subtract two numbers 3 - 2 :" + subtract( "3", "2"));
        //test subtract

        System.out.println("Multiply two numbers 3 X 3 :" + multiply( "3", "3"));
        //test multiply

        System.out.println("Divide two numbers 23/12:" + divide("23", "12"));

        System.out.println("Quaternary to Decimal 12: " + quaternaryToDecimal("12"));
    }
}
