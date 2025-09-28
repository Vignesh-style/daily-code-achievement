package org.victor.array;

/**
 * Hackerrank question ::
 * You are given an array of integers arr and a target k. Find the length of the smallest subarray whose sum is strictly greater than k. If no such subarray exists, return -1.
 * */

public class SmallestSubarrayGreaterThanK {

    public static  int minSubArrayLen(int k, int[] arr) {

        int min_len = Integer.MAX_VALUE;

        if (arr.length == 0) return 0;

        int l = 0;
        int r = 0;
        int subArraySum = 0;

        while (r < arr.length){

            subArraySum += arr[r];

            while (subArraySum >= k && l <= r) {
                min_len = Math.min(min_len, r - l + 1);
                System.out.println("sum : " + subArraySum);
                System.out.println("l - " + l + " r - " + r + "size : " + (r - l + 1));
                subArraySum -= arr[l];
                System.out.println("sum af : " + subArraySum);
                l++;
            }

            r++;

        }

        System.out.println(min_len);

        return min_len == Integer.MAX_VALUE ? -1 : min_len;
    }

}
