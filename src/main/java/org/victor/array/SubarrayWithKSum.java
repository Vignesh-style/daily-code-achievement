package org.victor.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Scaler problem :: Given an array of integers A and an integer B.
 * Find the total number of subarrays having sum equals to B.

 * 1 <= length of the array <= 50000
 * -1000 <= A[i] <= 1000
 * */

public class SubarrayWithKSum {

    public int solve(ArrayList<Integer> list, int K) {

        Map<Integer, Integer> sizeMap = new HashMap<>();

        for (int i = 1; i < list.size(); i++) {
            list.set(i, list.get(i) + list.get(i -1));
        }

        int count = 0;

        for (int X : list) {

            int Y = X - K;

            if (X == K) {
                count++;
            }

            if (sizeMap.containsKey(Y)) {

                Integer prev_count = sizeMap.get(Y);
                count += prev_count;

            }

            sizeMap.put(X, sizeMap.getOrDefault(X, 0) + 1);
        }
        return count;
    }
}
