package org.victor.array;

import java.util.Random;

/**
 * Given an unsorted array of n distinct integers and a number k (1 ≤ k ≤ n), find the k-th smallest element in the array without sorting the entire array (i.e., aim for better than O(n log n) if possible).
 * GeeksforGeeks
 *
 * Logic / Approach:
 *
 * A classic algorithm for this is Quickselect, which is related to Quicksort.
 *
 * We pick a pivot, partition the array into elements less than pivot and greater than pivot.
 *
 * After partitioning, we know the pivot’s correct position (say index pos).
 *
 * If pos == k-1, pivot is the k-th smallest.
 *
 * If pos > k-1, recurse on the left subarray.
 *
 * If pos < k-1, recurse on the right subarray for the (k-pos-1)-th smallest.
 *
 * On average this gives O(n) time, O(1) (or O(n)) space depending on implementation.
 *
 * Worst-case is O(n²) (if poor pivot choices), but with randomisation or median-of-medians pivot you can get worst-case O(n)
 * GeeksforGeeks
 * +1
 * */

public class KthSmallestElement {
    private static final Random RANDOM = new Random();

    public static int kthSmallest(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        return quickselect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickselect(int[] arr, int left, int right, int kIndex) {
        if (left == right) {
            return arr[left];
        }
        int pivotIndex = left + RANDOM.nextInt(right - left + 1);
        pivotIndex = partition(arr, left, right, pivotIndex);

        if (kIndex == pivotIndex) {
            return arr[kIndex];
        } else if (kIndex < pivotIndex) {
            return quickselect(arr, left, pivotIndex - 1, kIndex);
        } else {
            return quickselect(arr, pivotIndex + 1, right, kIndex);
        }
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        // move pivot to end
        swap(arr, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        // move pivot to its final place
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array1 = {10, 5, 4, 3, 48, 6, 2, 33, 53};
        int k1 = 4;
        System.out.println("Input: " + java.util.Arrays.toString(array1) + ", k=" + k1);
        System.out.println("Output: " + kthSmallest(array1, k1));  // expected 6

        int[] array2 = {7, 10, 4, 3, 20, 15};
        int k2 = 3;
        System.out.println("Input: " + java.util.Arrays.toString(array2) + ", k=" + k2);
        System.out.println("Output: " + kthSmallest(array2, k2));  // expected 7
    }
}
