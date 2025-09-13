package org.victor.math;

import java.util.List;

/**
 * Scaler problem :: Given a number A. Return 1 if A is prime and return 0 if not.

   Note :
 * The value of A can cross the range of Integer.

 * */

public class IsPrimeFinder {

    public int findWithFactors(int A) {

        List<Integer> factors = new FactorsGenerator().getFactors(A);

        if(factors.size() <= 2){
            return 1;
        }

        return 0;
    }
}
