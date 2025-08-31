package org.victor.sorting;

/**
 * Scaler problem :: Given an integer array A, sort the array using Quick Sort.
 * */

public class QuickSort {

    public int[] sort(int[] A) {

        quickSort(A, 0, A.length - 1);
        return A;
    }

    public void quickSort(int[] arr, int l, int r){

        if  (l >= r) return;
        int pi_idx = partition(arr, l, r);

        quickSort(arr, l, pi_idx - 1);
        quickSort(arr, pi_idx + 1, r);

    }


    public int partition(int[] arr, int l, int r) {

        int pivot = arr[l];
        int pivot_index = l;

        l++;

        while (l <= r){

            if (arr[l] <= pivot)  l++;

            else if (arr[r] > pivot) r--;

            else swap(l, r, arr);

        }

        swap(r, pivot_index, arr);
        return r;
    }


    public void swap(int l, int r, int[] arr){

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

    }

}
