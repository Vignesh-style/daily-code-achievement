package org.victor.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Scaler problem :: You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.
 * Note: You cannot use any extra space
 * */

public class FactorSort {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer k1, Integer k2) {

                int f1 = getFactorsOf(k1);
                int f2 = getFactorsOf(k2);

                if (f1 == f2){
                    return Integer.compare(k1, k2);
                }

                else {
                    return Integer.compare(f1, f2);
                }

            }
        });


        // A.sort((k1, k2) -> {

        //     int f1 = getFactorsOf(k1);
        //     int f2 = getFactorsOf(k2);

        //     if (f1 == f2){
        //         return Integer.compare(k1, k2);
        //     }

        //     else {
        //         return Integer.compare(f1, f2);
        //     }

        // });

        return A;
    }

    private int getFactorsOf(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count;
    }

}
