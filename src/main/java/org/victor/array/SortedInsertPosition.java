package org.victor.array;

import java.util.ArrayList;

/**
 * Scaler problem :: You are given a sorted array A of size N and a target value B.
 * Your task is to find the index (0-based indexing) of the target value in the array.


 * If the target value is present, return its index.
 * If the target value is not found, return the index of least element greater than equal to B.
 * If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
 * Your solution should have a time complexity of O(log(N)).

 * */

public class SortedInsertPosition {

    public int searchInsert(ArrayList<Integer> A, int B) {

        int high = A.size() - 1;
        int low = 0;

        while (low <= high){

            int mid = low + (high - low) / 2;

            if (A.get(mid) == B){
                return mid;
            }
            else if (A.get(mid) < B){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }

        }
        return low;
    }
}
