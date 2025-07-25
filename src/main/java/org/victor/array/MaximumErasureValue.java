package org.victor.array;

import java.util.HashSet;
import java.util.Set;

/**
  Problem No. 1695.
    MaximumErasureValue - You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
    Return the maximum score you can get by erasing exactly one subarray.
    An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

  Constraints:
    1 <= nums.length <= 105
    1 <= nums[i] <= 10

   Proposed Solution : TC O(N) | SC O(N)

 * */

public class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {

        int ret;
        int maxValue;

        int st = 0;
        int ed = 1;

        if (nums.length == 1) return nums[0];

        Set<Integer> uniqueWindow = new HashSet<>();
        uniqueWindow.add(nums[st]);
        maxValue = nums[st];
        ret = nums[st];

        while (ed < nums.length){
            if (uniqueWindow.contains(nums[ed])){

                while (st < ed){

                    if (nums[st] != nums[ed]){
                        maxValue = maxValue - nums[st];
                        uniqueWindow.remove(nums[st]);
                        st++;
                    }

                    else {
                        st++;
                        ed++;
                        break;
                    }
                }

            }

            else {
                uniqueWindow.add(nums[ed]);
                maxValue = maxValue + nums[ed];
                ret = Math.max(ret, maxValue);
                ed++;
            }
        }

        return ret;
    }
}

