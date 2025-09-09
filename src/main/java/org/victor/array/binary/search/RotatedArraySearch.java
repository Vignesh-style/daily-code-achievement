package org.victor.array.binary.search;

import java.util.List;

/**
 * Scaler problem :: Given a sorted array of integers A of size N and an integer B, where array A is rotated at some pivot unknown beforehand.

 * For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
 * Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
 * You can assume that no duplicates exist in the array.

 * NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
 * */

public class RotatedArraySearch {

    public int search(final List<Integer> A, int B) {

        if (A.isEmpty()) return -1;
        else if (A.size() == 1) return A.getFirst();

        int low = 0;
        int high = A.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (B == A.get(mid)) return mid;

            else {

                //p1
                if (B >= A.getFirst()){

                    //p1
                    if (A.get(mid) >= A.getFirst()){

                        if (A.get(mid) > B) high = mid - 1;

                        else low = mid + 1;

                    }

                    //p2
                    else high = mid - 1;
                }

                //p2
                if (B < A.getFirst()){

                    //p1
                    if (A.get(mid) >= A.getFirst()){
                        low = mid + 1;
                    }

                    //p2
                    else {

                        if (A.get(mid) > B) high = mid - 1;
                        else low = mid + 1;

                    }
                }
            }
        }
        return -1;
    }
}
