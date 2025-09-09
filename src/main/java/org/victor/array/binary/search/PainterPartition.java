package org.victor.array.binary.search;

import java.util.ArrayList;

/** //todo Classic Problem.
 * Scaler problem :: Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

 * Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
 NOTE:
 * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
 * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
 * 3. Return the ans % 10000003.

 Problem Constraints

 1 <= A <= 1000
 1 <= B <= 10^6
 1 <= N <= 10^5
 1 <= C[i] <= 10^6

 * */

public class PainterPartition {

    public int paint(int A, int B, ArrayList<Integer> C) {

        int n = C.size();

        int maxBoardLength = 0;
        int totalBoardLength = 0;
        for (int length : C) {
            maxBoardLength = Math.max(maxBoardLength, length);
            totalBoardLength += length;
        }

        int low = maxBoardLength;
        int high = totalBoardLength;
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(C, n, A, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;}
        }
        return (int) ((long) result * B % 10000003);
    }

    private boolean isPossible(ArrayList<Integer> C, int n, int A, int maxTime) {

        int painters = 1;
        int currentTime = 0;

        for (int length : C) {
            if (currentTime + length > maxTime) {
                painters++;
                currentTime = length;

                if (painters > A) {
                    return false;
                }
            } else {
                currentTime += length;
            }
        }
        return true;
    }
}
