package org.victor.math;

/**
 * Scaler problem :: Given a number A, check if it is a magic number or not.

 * A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively
 * by adding the sum of the digits after every addition. If the single digit comes out to be 1,
 * then the number is a magic number.

 1 <= A <= 10^9
 * */

public class MagicNumber {

    public int solve(int A) {

        int ret = 1 + ((A - 1) % 9);
        if (ret == 1) return 1;
        return 0;

    }
}
