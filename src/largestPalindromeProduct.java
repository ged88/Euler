// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//
// Find the largest palindrome made from the product of two 3-digit numbers.


public class largestPalindromeProduct {

    private static boolean isPalinDrome(int n) {
        return isPalinDrome(Integer.toString(n) ) ;
    }

    private static boolean isPalinDrome(String s) {
        for(int i=0; i<s.length();i++) {
            if (s.charAt(i)!=s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int result = 0;
        int x = 0;
        int y = 0;

        for(int i=1;i<1000;i++) {
            for(int j=1; j<1000;j++) {
                int product = i*j;
                if (isPalinDrome(product)){
                    if (product > result) {
                        result = product;
                        x=i;
                        y=j;
                    }
                }
            }
        }

        System.out.println();
        System.out.println("Grootste gevonden PalinDeome = "+ result);
        System.out.println("X = " + x);
        System.out.println("Y = " + y);
    }
}
