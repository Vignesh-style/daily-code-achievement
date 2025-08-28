package org.victor.bit.manipulation;

import java.util.List;

/**
 * Scaler problem :: Given an array of integers, every element appears thrice except for one, which occurs once.
 * Find that element that does not appear thrice.

 * NOTE: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?  --> this is the reason bit-manipulation come into mind
 * */

public class SingleNumberI {

    public int singleNumber(final List<Integer> A) {

        int sN = 0;
        int i = 0;

        while (i < 31){

            int bit_counter = 0;

            for (Integer a : A)
                if ( (a & 1 << i) > 0 ) bit_counter++;

            if ((bit_counter % 3) != 0) sN = sN | 1 << i;

            i++;
        }
        return sN;
    }
}
