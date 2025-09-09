package org.victor.array.binary.search;

import java.util.ArrayList;
import java.util.Collections;

/**
 * //todo classic problem
 * Scaler problem :: Farmer John has built a new long barn with N stalls.

 * Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
 * His cows don't like this barn layout and become aggressive towards each other once put into a stall.
 * To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
 * such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

 Problem Constraints

 2 <= N <= 100000
 0 <= A[i] <= 10^9
 2 <= B <= N

 * */

public class AggressiveCows {

    public int solve(ArrayList<Integer> A, int B) {

        Collections.sort(A);

        int low = 1;
        int high = A.getLast() - A.getFirst();
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(A, B, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private boolean isPossible(ArrayList<Integer> A, int B, int minDist) {
        int count = 1;
        int lastPlaced = A.getFirst();

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) - lastPlaced >= minDist) {
                count++;
                lastPlaced = A.get(i);

                if (count == B) {
                    return true;
                }
            }
        } return false;
    }
}
