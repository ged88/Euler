import java.math.BigInteger;

// 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//
//What is the sum of the digits of the number 2^1000?

public class Problem16PowerDigitSum {

    public static void main(String[] args) {
        BigInteger powerOfTwo = new BigInteger("1");

        for (int i=1; i<=1000;i++){
            powerOfTwo = powerOfTwo.multiply(BigInteger.valueOf(2));
        }
        System.out.println(powerOfTwo.toString());

        String numberStr = powerOfTwo.toString();
        int length = numberStr.length();
        int sum = 0;

        for (int i=0; i<length;i++) {
            sum += Character.getNumericValue(numberStr.charAt(i));
        }
        System.out.println("Sum of digits : " + sum);
    }

}
