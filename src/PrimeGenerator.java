// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
// What is the 10 001st prime number?

public class PrimeGenerator {

    private static boolean isPrimeNmb(long n) {
        if (n%2==0){
            return false;
        }

        for (long i=3; i*i<=n;i=i+2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
            long number = 0;
        int numberOfPrimesFound = 0;
        int primeNumber = 10001;

        while (numberOfPrimesFound<primeNumber) {
            number++;

            if (isPrimeNmb(number)) {
                numberOfPrimesFound++;
            }
        }
        System.out.println(primeNumber + " : " + number);

    }
}
