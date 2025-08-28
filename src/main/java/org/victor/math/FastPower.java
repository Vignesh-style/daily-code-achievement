package org.victor.math;

/**
 * Scaler Problem :: Given two positive integers A and B. Implement Fast Power function to compute A^B
 A^B would fit in 64-bit type integer.
 * */

public class FastPower {

    public Long power(int A, int B) {

        if(B == 0) return 1L;

        Long pow = power(A, B/2);

        if (B % 2 == 0) return pow * pow;

        else return (pow * pow ) * A;

    }
}
