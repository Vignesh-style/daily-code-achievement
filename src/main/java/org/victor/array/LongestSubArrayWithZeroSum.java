package org.victor.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Scaler problem :: Given an array A of N integers.
 * Find the length of the longest subarray in the array which sums to zero.
 * If there is no subarray which sums to Zero, then return 0.
 * */

public class LongestSubArrayWithZeroSum {

    public int solve(ArrayList<Integer> A) {

        Map<Long, Integer> prefixSumMap = new HashMap<>();
        Long prefixSum = 0L;
        Integer maxLength = 0;

        for (int i = 0; i < A.size(); i++) {

            prefixSum += A.get(i);

            if (prefixSum == 0)
                maxLength = Math.max(maxLength, i + 1);

            else {
                if (prefixSumMap.containsKey(prefixSum)) {
                    Integer prevIdx = prefixSumMap.get(prefixSum);
                    maxLength = Math.max(maxLength, (i - prevIdx ));
                }
                else
                {
                    prefixSumMap.put(prefixSum, i);
                }
            }
        }
        return  maxLength;
    }
}
