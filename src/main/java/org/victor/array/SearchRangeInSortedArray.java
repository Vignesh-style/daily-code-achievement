package org.victor.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Scaler problem :: Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

 * Return an array of size 2, such that
 *           First element = Left most index of B in A
 *           Second element = Right most index of B in A.
 * If B is not found in A, return [-1, -1].

 * Note : Note: The time complexity of your algorithm must be O(log n)..
 * */

public class SearchRangeInSortedArray {

    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {

        Integer left = -1;
        Integer right = -1;

        // iterating for left end.

        int high = A.size() - 1;
        int low = 0;

        while (low <= high){

            int mid = low + (high - low) / 2;

            if (A.get(mid) == B){
                high = mid - 1;
                left = mid;
            }
            else if (A.get(mid) < B){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        if (left == -1){
            list.add(left);
            list.add(right);
            return list;
        }

        // iterating for right end.

        int h = A.size() - 1;
        int l = left;

        while (l <= h){

            int mid = l + (h - l) / 2;

            if (A.get(mid) == B){
                l = mid + 1;
                right = mid;
            }
            else if (A.get(mid) < B){
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }

        list.add(left);
        list.add(right);
        return list;
    }
}
