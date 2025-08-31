package org.victor.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Scaler Problem :: Given an integer array A, sort the array using Merge Sort.

 * Problem Constraints
 * 1 <= |A| <= 10^5
 * 1 <= A[i] <= 10^9
 * */

public class MergeSort {

    public ArrayList<Integer> sort(ArrayList<Integer> A) {
        mergeSort(A, 0, A.size() - 1);
        return A;
    }

    public static void mergeSort(List<Integer> list, int low, int high){

        if (low == high) return;

        int mid = low + (high - low) / 2;
        mergeSort(list, low, mid);
        mergeSort(list, mid + 1, high);

        merge(list, low, mid, high);
    }


    private static void merge(List<Integer> list, int low, int mid, int high) {

        int l1 = ( mid - low ) + 1;
        int l2 = high - mid;

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

            if (list1.get(lp1) < list2.get(lp2)){
                list.set(idx, list1.get(lp1));
                lp1++;
            }
            else {
                list.set(idx, list2.get(lp2));
                lp2++;
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
    }
}
