import junit.framework.Assert;
import org.junit.Test;

public class CalculatorTest{

    @Test
    //testing for sum operation
    public void testSum(){
        Calculator calculator = new Calculator();

        int result = calculator.sum(2,2);
    

        Asset.assertEquals(10,result);
    }

     @Test
    //testing for Minus operation
    public void testMinus(){
        Calculator calculator = new Calculator();

        int result = calculator.minus(10,2);
    

        Asset.assertEquals(2,result);
    }

     @Test
    //testing for multiply operation
    public void testMultiply(){
        Calculator calculator = new Calculator();

        int result = calculator.multiply(2,2);
    

        Asset.assertEquals(10,result);

}

@Test
    //testing for division operation
    public void testDivide(){
        Calculator calculator = new Calculator();

        int result = calculator.divide(12,4);
    

        Asset.assertEquals(3,result);

    }




public class Calculator {
    public static int quaternaryToDecimal(String quaternary) {
        int decimal = 0;
        int base = 1;

        for (int i = quaternary.length() - 1; i >= 0; i--) {
            char digit = quaternary.charAt(i);
            decimal += (digit - '0') * base;
            base *= 4;
        }

        return decimal;
    }

    // Convert decimal number to quaternary
    public static String decimalToQuaternary(int decimal) {
        if (decimal == 0) return "0";

        StringBuilder quaternary = new StringBuilder();
        while (decimal > 0) {
            quaternary.insert(0, decimal % 4);
            decimal /= 4;
        }

        return quaternary.toString();
    }

    // Perform arithmetic operations
    public static String calculate(int firstNumber, int secondNumber, String operator) {
        int result = 0;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "x":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) throw new ArithmeticException("Division by zero");
                result = firstNumber / secondNumber;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        return decimalToQuaternary(result);
    }

    // Perform unary operations
    public static String performUnaryOperation(String operator, int number) {
        int result;

        switch (operator) {
            case "square":
                result = number * number;
                break;
            case "sqrt":
                result = (int) Math.sqrt(number);
                break;
            default:
                throw new IllegalArgumentException("Invalid unary operator: " + operator);
        }

        return decimalToQuaternary(result);
    }

    public static void calculate() {
    }
}

