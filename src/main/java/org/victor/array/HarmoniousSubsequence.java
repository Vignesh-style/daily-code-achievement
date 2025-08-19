package org.victor.array;

import java.util.Arrays;

/**
 * LeetCode :: 594. Longest Harmonious Subsequence

 We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

 * */

public class HarmoniousSubsequence {

    public int findLHS(int[] nums) {

        Arrays.sort(nums);

        if (nums.length == 1) return 0;

        int LHS = 0;
        int l = 0;
        int r = 1;

        while (r < nums.length && l <= r){

            if (l == r) {
                r++;
                continue;
            }

            int diff = nums[r] - nums[l];

            if (diff > 1){
                l++;
                continue;
            }

            else if (diff == 1){
                LHS = Math.max(LHS, r - l + 1);
            }
            r++;
        }

        return LHS;
    }

}
