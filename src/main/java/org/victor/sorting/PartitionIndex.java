package org.victor.sorting;

/**
 * Scaler problem :: Given an integer array A of length N, considering the last element as pivot p, rearrange the elements such that for all i:

 * if A[i] < p then it should be present on the left side of the partition
 * if A[i] > p then it should be present on the right side of the partition
 * Rearrange the given array as well as return the partition index.

 * Note: All elements are distinct
 * */

public class PartitionIndex {

    public int partition(int[] arr) {

        int n = arr.length;
        int r = n - 2;
        int l = 0;

        int pivot = arr[n - 1];

        while (l <= r){

            if (arr[l] >= pivot){
                swap(l, r, arr);
                r--;
            }
            else l++;
        }


        // for (int i = n-2; i > r; i--){
        //     arr[i + 1] = arr[i];
        // }
        // arr[r + 1] = pivot;

        swap(l, arr.length - 1, arr);

        return l;

    }


    public void swap(int l, int r, int[] arr){

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

    }

}
