package org.victor.array;

/**
 * Given an integer array and an integer K (number of allowed “changes/replacements”), find the maximum possible sum of a contiguous sub-array when you are allowed to replace up to K elements (for example, replacing negative values with zero or some other strategy)
 * */

public class MaxSubarrayWithKReplacements {
    public static int maxSumWithKReplacements(int[] arr, int K) {
        int left = 0;
        int replacementCount = 0;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] < 0) {
                replacementCount++;
            }
            currentSum += (arr[right] < 0 ? 0 : arr[right]);  // treat replaced negative as zero

            while (replacementCount > K) {
                if (arr[left] < 0) {
                    replacementCount--;
                }
                currentSum -= (arr[left] < 0 ? 0 : arr[left]);
                left++;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {4, -1, 2, -5, 3, -2, 1};
        int K = 2;
        System.out.println(maxSumWithKReplacements(arr, K));  
        // Sample output: window [4, -1, 2, -5, 3] with two negatives replaced => sum = 4+0+2+0+3 = 9
    }
}
