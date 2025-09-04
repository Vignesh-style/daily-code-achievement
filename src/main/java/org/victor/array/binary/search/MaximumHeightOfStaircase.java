package org.victor.array.binary.search;

/**
 * Scaler problem :: Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
 * The first stair would require only one block, and the second stair would require two blocks, and so on.
 * Find and return the maximum height of the staircase.

 * Problem Constraints
 * 0 <= A <= 109
 * */

public class MaximumHeightOfStaircase {

    public int solve(int A) {

        if (A == 1) return 1;

        int high = A;
        int low = 1;

        int ans = 0;

        while (low <= high){

            int mid = low  + (high - low) / 2;

            if (isMaximumHeightCanBeReached(mid, A)) {
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return ans;
    }

    public static boolean isMaximumHeightCanBeReached(int maxHeight, int blocks){
        long sum = (long) maxHeight * ((long) maxHeight + 1) / 2;
        return sum <= blocks;
    }
}
