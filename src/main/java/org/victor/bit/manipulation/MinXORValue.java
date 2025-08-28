package org.victor.bit.manipulation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Scaler Problem :: Given an integer array A of N integers,
 * find the pair of integers in the array which have minimum XOR value.
 * Report the minimum XOR value.
 * */

public class MinXORValue {

    public int findMinXor(ArrayList<Integer> A) {

        Collections.sort(A);
        int minXor = Integer.MAX_VALUE;

        for (int i = 0; i < A.size() - 1; i++){
            int j = i + 1;
            minXor = Math.min(minXor, A.get(i) ^ A.get(j));

        }

        return minXor;
    }
}
