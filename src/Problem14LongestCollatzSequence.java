public class Problem14LongestCollatzSequence {
// The following iterative sequence is defined for the set of positive integers:
//
//n → n/2 (n is even)
//n → 3n + 1 (n is odd)
//
//Using the rule above and starting with 13, we generate the following sequence:
//
//13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//
//Which starting number, under one million, produces the longest chain?
//
//NOTE: Once the chain starts the terms are allowed to go above one million.

    static private long nIsEven(long n) {
        return n/2;
    }

    static private long nIsOdd(long n) {
        return 3*n+1;
    }


    public static void main(String[] args) {
        int lengthChain;
        long chainStep;
        int maxLength = 0;
        int maxStartnmb = 0;

        for (int i=2; i<1000000; i++) {
            lengthChain = 0;
            chainStep = i;

            while (chainStep != 1) {
                if ((chainStep%2)==0) chainStep = nIsEven(chainStep);
                else chainStep = nIsOdd(chainStep);
                lengthChain += 1;
            }

            if (lengthChain>maxLength) {
                maxLength=lengthChain;
                maxStartnmb=i;
            }
        }

        System.out.println("Startwaarde: " + maxStartnmb);
        System.out.println("Aantal stappen: " + maxLength);
    }
}
