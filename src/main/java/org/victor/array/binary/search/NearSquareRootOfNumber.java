package org.victor.array.binary.search;

/**
 * Scaler problem :: Given an integer A. Compute and return the square root of A.
 * If A is not a perfect square, return floor(sqrt(A)).

 * NOTE:
 *    The value of A*A can cross the range of Integer.
 *    Do not use the sqrt function from the standard library.
 *    Users are expected to solve this in O(log(A)) time.
 * */

public class NearSquareRootOfNumber {

    public int sqrt(int A) {

        int low = 0;
        int high = A/2;

        if (A == 0) return 0;

        if (A <= 2) return 1;

        while (low <= high){

            int mid = low + (high - low) / 2;

            long X = (long) mid * mid;

            if (X == A) return mid;

            else if (X > A) high = mid - 1;

            else low = mid + 1;
        }
        return high;
    }
}
