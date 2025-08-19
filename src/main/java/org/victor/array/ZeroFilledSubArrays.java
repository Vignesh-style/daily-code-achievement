package org.victor.array;

/**
 * LeetCode -- 2348. Number of Zero-Filled Subarrays

 * Given an integer array arr, return the number of subarrays filled with 0.
 * A subarray is a contiguous non-empty sequence of elements within an array.

 * */

public class ZeroFilledSubArrays {

    public long getZeroFilledSubarrayCount(int[] arr) {

        long consecutive_zero = 0L;
        long subarray_with_zero = 0L;

        for (int i = 0; i < arr.length; i++){

            if (arr[i] == 0){
                consecutive_zero++;
            }

            if ((arr[i] != 0 && consecutive_zero != 0 ) || (i == arr.length - 1 && consecutive_zero != 0)){
                long n = consecutive_zero;
                subarray_with_zero += ( n * ( n + 1 ) ) / 2;
                consecutive_zero = 0L;
            }
        }

        return subarray_with_zero;

    }
}
