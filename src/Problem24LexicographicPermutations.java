// A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
// If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
// The lexicographic permutations of 0, 1 and 2 are:
//
//012   021   102   120   201   210
//
//What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem24LexicographicPermutations {

    static ArrayList<String> permList = new ArrayList<>();

    public static void heaps_algorithm(int[] a, int n) {
        if(n == 1) {
            permList.add(Arrays.toString(a));
            return;
        }
        for(int i = 0;i < (n - 1);i++) {
            heaps_algorithm(a, n-1);
            if(n % 2 == 0) swap(a, n-1, i);
            else swap(a, n-1, 0);
        }
        heaps_algorithm(a, n-1);
    }
    private static void swap(int[] a, int i1, int i2) {
        int tmp = a[i1];
        a[i1] = a[i2];
        a[i2] = tmp;
    }


    public static void main(String[] args) {
       int[] perm = new int[10];

       for (int i=1; i<=10; i++) {
           perm[i-1]=i;
       }
       heaps_algorithm(perm, 10);
       Collections.sort(permList);
       System.out.println(permList.get(1000000));
    }
}
