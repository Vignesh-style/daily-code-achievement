package org.victor.math;

/**
 * Scaler problem :: You are given an integer A. You have to tell whether it is a perfect number or not.
 * Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
 * A proper divisor of a natural number is the divisor that is strictly less than the number.
 * */

public class PerfectNumber {

    public int solve(int A) {

        if(A < 6){
            return 0;
        }

        int sum = getSumFactorsExclusiveOfInput(A);

        if (sum == A){
            return 1;
        }

        return 0;
    }


    public static int getSumFactorsExclusiveOfInput(int n) {

        int factor_sum = 0;

        for (int i = 1; i * i <= n; i++) {

            if (n % i == 0 && i * i < n) {
                factor_sum = factor_sum + i;
                if (i != 1) {
                    factor_sum = factor_sum + n / i;
                }
            } else if (n % i == 0 && i * i == n) {
                factor_sum = factor_sum + i;
            }

        } return factor_sum;
    }
}
