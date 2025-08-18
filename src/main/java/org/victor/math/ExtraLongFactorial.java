package org.victor.math;

import java.math.BigInteger;

/** HackerRank.
 * The factorial of the integer n, written n!, is defined as: n! = n × (n − 1) × (n − 2) × ⋯ × 3 × 2 × 1

 * Calculate and print the factorial of a given integer.
    For example, if n = 30, we calculate 30 × 29 × 28 × ⋯ × 2 × 1 and get 265252859812191058636308480000000.

 * Function Description - Complete the extraLongFactorials function in the editor below. It should print the result and return. extraLongFactorials has the following parameter(s):
    n: an integer
 * Note: Factorials of n > 20 can’t be stored even in a 64-bit long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers, but we need to write additional code in C/C++ to handle huge values.
 * */

public class ExtraLongFactorial {

    public static BigInteger extraLongFactorials(int n) {
        return fact(n);
    }

    public static BigInteger fact(int n){
        if (n == 1) return new BigInteger("1");
        return (new BigInteger(n + "").multiply(fact(n - 1)));
    }
}
