package org.victor.array;

/**
 * LeetCode :: problem

 * Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
 * Return the largest lucky integer in the array. If there is no lucky integer return -1.

 * */

public class LuckNumberInArray {

    public int findLucky(int[] arr) {

        int ret = -1;

        int[] freqArr = new int[501];

        int max = 0;

        for (int ar : arr){
            max = Math.max(max, ar);
            freqArr[ar]++;
        }

        for (int i = max; i >= 1; i--){
            if (freqArr[i] == i) return i;
        }

        return ret;
    }
}
