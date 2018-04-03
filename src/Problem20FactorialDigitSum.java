// n! means n × (n − 1) × ... × 3 × 2 × 1
//
//For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
//and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
//
//Find the sum of the digits in the number 100!


import java.math.BigInteger;

public class Problem20FactorialDigitSum {

    public static void main(String[] args) {
        BigInteger faculty = new BigInteger("1");

        for (int i=1; i<=100;i++){
            faculty = faculty.multiply(BigInteger.valueOf(i));
        }
        System.out.println(faculty.toString());

        String numberStr = faculty.toString();
        int length = numberStr.length();
        int sum = 0;

        for (int i=0; i<length;i++) {
            sum += Character.getNumericValue(numberStr.charAt(i));
        }
        System.out.println("Sum of digits : " + sum);

    }
}
