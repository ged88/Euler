// The prime factors of 13195 are 5, 7, 13 and 29.
//
//What is the largest prime factor of the number 600.851.475.143 ?

public class LargestPrimeFactor {

    public static String findLargestFactor(long upperNumber) {
        String s = "";
        long divider;
        for (divider=1; (divider *divider)<upperNumber; divider=divider+2 ) {
            if (upperNumber%divider == 0) {
                if (isPrimeNmb(divider)) {
                    s = s + " " + divider;
                }
            }
        }
        return s;
    }

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

        long time = System.nanoTime();
        long prime = 600851475143L;
        //long prime = 13195;

        System.out.println();
        System.out.println(findLargestFactor(prime));
        System.out.println("Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
    }
}
