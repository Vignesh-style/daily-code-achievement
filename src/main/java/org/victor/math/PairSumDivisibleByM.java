package org.victor.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Scaler problem :: Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

 * Since the answer may be large, return the answer modulo (10^9 + 7).
 * Note: Ensure to handle integer overflow when performing the calculations.

 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^9
 * 1 <= B <= 10^6
 * */

public class PairSumDivisibleByM {

    public int solve(ArrayList<Integer> A, int B) {

        final int MOD = 1_000_000_007;
        Map<Integer, Integer> modBy = new HashMap<>();

        int idx = 0;
        int pairCount = 0;


        for (Integer a : A){

            Integer b = a % B;

            Integer bComplement = B - b;

            if (bComplement == B)
                bComplement = 0;

            if (modBy.containsKey(bComplement))
                pairCount = (pairCount  + modBy.get(bComplement)) % MOD;

            modBy.put(b, (modBy.getOrDefault(b, 0) + 1 ) % MOD);

            idx++;

        }

        return pairCount;

    }

}
