package Test;


public class Calculator {

    // Quaternary to Decimal
    public static String quaternaryToDecimal(String quaternary) {
        int decimal = Integer.parseInt(quaternary, 4);
        return String.valueOf(decimal);
    }
    public static String add(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int maxLength = Math.max(a.length(), b.length());

        // Padding shorter string with leading zeros
        a = String.format("%" + maxLength + "s", a).replace(' ', '0');
        b = String.format("%" + maxLength + "s", b).replace(' ', '0');

        for (int i = maxLength - 1; i >= 0; i--) {
            int digitA = a.charAt(i) - '0';
            int digitB = b.charAt(i) - '0';
            int sum = digitA + digitB + carry;
            carry = sum / 4;
            result.insert(0, sum % 4);
        }

        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }

    public static String subtract(String a, String b) {
        StringBuilder result = new StringBuilder();
        int borrow = 0;
        int maxLength = Math.max(a.length(), b.length());

        // Padding shorter string with leading zeros
        a = String.format("%" + maxLength + "s", a).replace(' ', '0');
        b = String.format("%" + maxLength + "s", b).replace(' ', '0');

        for (int i = maxLength - 1; i >= 0; i--) {
            int digitA = a.charAt(i) - '0';
            int digitB = b.charAt(i) - '0' + borrow;
            if (digitA < digitB) {
                digitA += 4;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.insert(0, digitA - digitB);
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    public static String multiply(String a, String b) {
        String result = "0";
        int shift = 0;

        for (int i = b.length() - 1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();
            int carry = 0;
            int digitB = b.charAt(i) - '0';

            for (int j = a.length() - 1; j >= 0; j--) {
                int digitA = a.charAt(j) - '0';
                int product = digitA * digitB + carry;
                carry = product / 4;
                temp.insert(0, product % 4);
            }

            if (carry > 0) {
                temp.insert(0, carry);
            }

            // Shift the result based on the position of the digit in 'b'
            for (int k = 0; k < shift; k++) {
                temp.append("0");
            }

            result = add(result, temp.toString());
            shift++;
        }

        return result;
    }

    public static String divide(String a, String b) {
        if (b.equals("0")) {
            return "Error: Division by zero";
        }

        String quotient = "0";
        String remainder = a;

        while (compareQuaternary(remainder, b) >= 0) {
            String tempQuotient = "1";
            String tempB = b;

            while (compareQuaternary(multiply(tempB, "2"), remainder) <= 0) {
                tempB = multiply(tempB, "2");
                tempQuotient = multiply(tempQuotient, "2");
            }

            remainder = subtract(remainder, tempB);
            quotient = add(quotient, tempQuotient);
        }

        return quotient;
    }

    private static int compareQuaternary(String a, String b) {
        a = a.replaceFirst("^0+", "");
        b = b.replaceFirst("^0+", "");

        if (a.length() != b.length()) {
            return a.length() - b.length();
        }

        return a.compareTo(b);
    }
    // add main method for testing operations purpose

    public static void main(String[] args) {

        System.out.println("Add two numbers 10 + 3 :" + add( "10", "3"));
        //test add

        System.out.println("Subtract two numbers 3 - 2 :" + subtract( "3", "2"));
        //test subtract

        System.out.println("Multiply two numbers 3 X 3 :" + multiply( "3", "3"));
        //test multiply

        System.out.println("Divide two numbers 23 / 12:" + divide("23", "12"));
    }
}





