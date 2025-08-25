package org.victor.array;

import java.util.ArrayList;

/**
 * Scaler problem :: Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

 Note:
 It is possible to swap any two elements, not necessarily consecutive.

 * */

public class MinimumSwaps {

    public int minSwaps(ArrayList<Integer> A, int B) {

        int count = 0;
        int i = 0;

        while (i < A.size()) {
            if (A.get(i) <= B) count++;
            i++;
        }

        if (count <= 1) {
            return 0;
        }

        int minSwaps;
        int badElements = 0;

        int j = 0;
        while (j < count) {
            if (A.get(j) > B) badElements++;
            j++;
        }

        minSwaps = badElements;

        int l = 0;
        int r = count;

        while (r < A.size()) {

            if (A.get(l) > B) badElements--;
            if (A.get(r) > B) badElements++;

            minSwaps = Math.min(minSwaps, badElements);

            l++;
            r++;
        }
        return minSwaps;
    }
}
