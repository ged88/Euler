// Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
//
//1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//
//By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

public class EvenFibonacciNumbers {
    public static void main(String[] args){

        int FibNmb1 = 0;
        int FibNmb2 = 1;
        int FibNmbNext = 2;
        int result = 0;

        while (FibNmbNext <= 4000000) {
            if ((FibNmbNext%2) == 0)
                result += FibNmbNext;

            FibNmb1 = FibNmb2;
            FibNmb2 = FibNmbNext;
            FibNmbNext = FibNmb1 + FibNmb2;
        }
        System.out.println(result);
    }
}