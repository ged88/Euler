import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SummationOfPrimes {
    // Euler Problem 10
    // The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    //
    //Find the sum of all the primes below two million.

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


    public static void main(String[] args) {
        int limit = 30; //2000000;
        long sumPrimes = 0;
        int squareRootLimit;
        boolean prime = true;
        boolean endPrimeSearch;

        Set<Integer> set = new HashSet<Integer>();
        set.add(2);

        for (int i=3; i<= limit; i=i+2) {
            Iterator<Integer> iter = set.iterator();
            prime = true;
            endPrimeSearch = false;
            while (!endPrimeSearch) {
                if (iter.hasNext()) {

                    if ((i % iter.next()) == 0) {
                        prime = false;
                        endPrimeSearch = true;
                    }
                } else {
                    endPrimeSearch = true;
                }
            }

            if (prime) {
                // prime = isPrimeNmb(i);
                // if (prime) {
                System.out.println("priem: "+ i);
                    set.add(i);
               // }
            }
        }

        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            sumPrimes += iter.next();

        }

        System.out.println("Totaal = " + sumPrimes);

    }
}
