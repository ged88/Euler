// Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
//If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
//
//For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
//
//Evaluate the sum of all the amicable numbers under 10000.


public class Problem21AmicableNumbers {

    public static int sumDivisors(int factor) {
        int sum=0;

        for (int divisor=(factor+1)/2; divisor>0; divisor--) {
            if ((factor%divisor)==0)
                 sum+=divisor;
        }
        return sum;
    }

    public static void main(String[] args){

        int maxNmb = 10000;
        int sum1, sum2;
        int amiceFactor;
        int result = 0;

        // Bereken de som van al de delers voor ieder getal tot 100000
        for (int factor=0; factor<maxNmb; factor++){
            sum1=sumDivisors(factor);

            if (sum1!=factor) {
                if (factor==sumDivisors(sum1)) {
                    result+=factor;
                    System.out.println(factor);
                }
            }
        }
        System.out.println(result);
    }

}
