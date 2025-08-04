package org.victor.array;

import java.util.Arrays;

/**
 * Leet Code Problem. 2294

 *      You are given an integer array nums and an integer k. You may partition nums into one or more subsequences such that each element in nums appears in exactly one of the subsequences.
 *      Return the minimum number of subsequences needed such that the difference between the maximum and minimum values in each subsequence is at most k.
 *      A subsequence is a sequence th  at can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 * */

public class PartitionArray {

    public int partitionArray(int[] nums, int k) {

        Arrays.sort(nums); //nlogn

        int count = 0;

        // List<List<Integer>> pq = new ArrayList<>();

        int min = nums[0];

        //[1,2,3,5,6,7].

        for (int i = 0; i < nums.length;){

            // List<Integer> tempList = new ArrayList<>();
            //  tempList.add(nums[i]);

            int j = i + 1;
            for (;j < nums.length; j++){

                if (nums[j] - nums[i] <= k){
                    // tempList.add(nums[j]);
                    continue;
                }

                i = j;
                break;
            }

            i = j;
            count++;

        }

        return count;

    }

}
