package org.victor.array;

/**
 * HackerEarth Problem :: Remove duplicate in the array in place.
 * */

public class RemoveDuplicate {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                nums[write++] = nums[read];
            }
        }
        return write;
    }
}
