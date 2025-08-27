package org.victor.array;

import java.util.ArrayList;

/**

 * Scaler problem :: Given an unsorted integer array, A of size N. Find the first missing positive integer.
 * Note: Your algorithm should run in O(n) time and use constant space.

 * */

public class FirstMissingIntFinder {

    public int firstMissingPositive(ArrayList<Integer> A) {

        //placeHolding the to outside the searching circle.
        int negativePlaceHolderValue = A.size() + 1;
        for (int i = 0; i < A.size(); i++){
            if (A.get(i) <= 0){
                A.set(i, negativePlaceHolderValue);
            }
        }


        for (int i = 0; i < A.size(); i++){

            int val = Math.abs(A.get(i));

            if (val <= A.size()  && A.get(val - 1) > 0)
                A.set(val - 1, A.get(val - 1) * -1);

        }

        for (int i = 0; i < A.size(); i++){
            if (A.get(i) > 0) return i + 1;
        }
        return A.size() + 1;
    }
}
