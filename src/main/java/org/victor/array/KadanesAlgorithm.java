package org.victor.array;

import java.util.List;

/**
 * Scaler Problem : : Given an array A of length N, your task is to find the maximum possible sum of any non-empty contiguous subarray.
 * */

public class KadanesAlgorithm {

    public int maxSubArray(final List<Integer> A) {

        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;

        for (Integer integer : A) {

            curr_sum += integer;

            if (curr_sum > max_sum) max_sum = curr_sum;

            if (curr_sum < 0) curr_sum = 0;

        }

        return max_sum;
    }

}
