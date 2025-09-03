package org.victor.array;

import java.util.ArrayList;

/**
 * Scaler problem :: Given an array of integers A, find and return the peak element in it.
 * An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

 * NOTE:
 * It is guaranteed that the array contains only a single peak element.
 * Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
 * */

public class PeakElement {

    public int solve(ArrayList<Integer> A) {

        if (A.size() == 1){
            return A.getFirst();
        }

        int low = 0;
        int high = A.size() -1;

        if (A.get(low) > A.get(low + 1))
            return A.get(low);

        else if (A.get(high) > A.get(high - 1)){
            return A.get(high);
        }

        else {

            while (low < high){

                int mid = low + (high - low) / 2;

                // System.out.println(low);
                // System.out.println(mid);
                // System.out.println(high);

                Integer midValue = A.get(mid);
                Integer leftValue = A.get(mid - 1);
                Integer rightValue = A.get(mid + 1);

                // System.out.println(leftValue);
                // System.out.println(midValue);
                // System.out.println(rightValue);

                // System.out.println("-------------");

                if (midValue > leftValue && midValue > rightValue){
                    return midValue;
                }

                else if (midValue >= leftValue && midValue <= rightValue)
                    low = mid + 1;

                else
                    high = mid - 1;

            }

            return A.get(high);

        }
    }

}
