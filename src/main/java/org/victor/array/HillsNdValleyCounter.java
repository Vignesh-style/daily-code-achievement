package org.victor.array;

/**
 *  Leet-Code Problem No.2210

        You are given a 0-indexed integer array nums. An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i]. Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i]. Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].
        Note that for an index to be part of a hill or valley, it must have a non-equal neighbor on both the left and right of the index.
        Return the number of hills and valleys in nums.

 * */

public class HillsNdValleyCounter {

    public int countHillValley(int[] nums) {

        int n = nums.length;
        int lastStageMarker = -1;
        int hills = 0;
        int valleys = 0;

        for (int i = 1; i < n - 1; i++){

            int left_pointer = i - 1;
            // System.out.println("idx  " + i);

            //left
            while (left_pointer >= 0 && nums[i] == nums[left_pointer]){
                left_pointer--;
            }

            // System.out.println("left   " + left_pointer);
            if (left_pointer < 0) continue;


            int right_pointer = i + 1;

            //right
            while (right_pointer <= n - 1 && nums[i] == nums[right_pointer]){
                right_pointer++;
            }

            // System.out.println("right  " + right_pointer);
            if (right_pointer >= n) continue;

            if (nums[left_pointer] > nums[i] && nums[right_pointer] > nums[i]){
                if (lastStageMarker != 1) valleys++;
                lastStageMarker = 1;
            } else if (nums[left_pointer] < nums[i] && nums[right_pointer] < nums[i]){
                if (lastStageMarker != 2) hills++;
                lastStageMarker = 2;
            }
        }
        return hills + valleys;
    }
}
