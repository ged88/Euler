// A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
// For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
//
//A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
//
//As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of
// two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written
// as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though
// it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
//
//Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.



public class Problem23NonAbundantSums {

    public static int sumDivisors(int factor) {
        int sum=0;

        for (int divisor=(factor+1)/2; divisor>0; divisor--) {
            if ((factor%divisor)==0)
                sum+=divisor;
        }
        return sum;
    }

    public static void main(String[] args) {

        int maxNmb = 28123;
        int[] sum = new int[maxNmb];
        boolean[] abundant = new boolean[maxNmb];

        for (int i=0; i<maxNmb; i++) {
            sum[i]=sumDivisors(i);
            abundant[i] = (sum[i]>i);
        }

        for (int i=0; i<maxNmb; i++) {
            if (abundant[i]) {
                System.out.println("i: " + i + "  som delers: "+ sum[i]);
            }
        }

        int abundantSum = 0;
        int j;
        boolean matchFound;
        for (int i=1; i<= maxNmb; i++){
            // check if i can be written as the sum of two abundant numbers

            j=1;
            matchFound = false;
            while ((j<i) && !matchFound) {
                if (abundant[i-j] && abundant[j]) {
                    // j en i-j zijn een paar
                    matchFound = true;
                } else {
                    j++;
                }
            }
            if (!matchFound) {
                abundantSum +=i;
            }
        }
        System.out.println("Rsultaat: "+ abundantSum);
    }
}
