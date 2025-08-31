package org.victor.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Scaler Problem :: Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A.
 * Find the total number of inversions of A modulo (10^9 + 7).
 * */


public class InversionCountInList {

    public int solve(ArrayList<Integer> A) {

        long[] inversion_count = new long[1];

        mergeSort(A, 0, A.size() - 1, inversion_count);

        return (int)(inversion_count[0] % 1_000_000_007);

    }

    public static void mergeSort(List<Integer> list, int low, int high, long[] inversion_count){

        if (low == high) return;

        int mid = low + (high - low) / 2;
        mergeSort(list, low, mid, inversion_count);
        mergeSort(list, mid + 1, high, inversion_count);

        inversion_count[0] += merge(list, low, mid, high);

    }


    private static long merge(List<Integer> list, int low, int mid, int high) {

        int l1 = ( mid - low ) + 1;
        int l2 = high - mid;

        long inversion_count = 0L;

        List<Integer> list1 = new ArrayList<>();
        for (int i = low; i <= mid ; i++) {
            list1.add(list.get(i));
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = mid + 1; i <= high; i++) {
            list2.add(list.get(i));
        }

        int lp1 = 0;
        int lp2 = 0;

        int idx = low;

        while (lp1 < l1 && lp2 < l2){

            if (list1.get(lp1) <= list2.get(lp2)){
                list.set(idx, list1.get(lp1));
                lp1++;
            }
            else {
                list.set(idx, list2.get(lp2));
                lp2++;
                inversion_count = (inversion_count +   (long)  (l1 - lp1 ));


            }
            idx++;
        }

        while (lp1 < l1){
            list.set(idx, list1.get(lp1));
            lp1++;
            idx++;
        }
        while (lp2 < l2){
            list.set(idx, list2.get(lp2));
            lp2++;
            idx++;
        }

        return inversion_count;
    }
}
