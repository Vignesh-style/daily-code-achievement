package org.victor.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Scaler Problem :: Given an array A of length N where all the elements are distinct and are in the range [1, N+2].
 * Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.

 * Note : Solve in constant space.*
 * */

public class FindTwoMissingNumbers {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        int n = A.size();

        ArrayList<Integer> totalNumbers = new ArrayList<>(n + 2);

        for (int i = 1; i <= n + 2; i++){
            totalNumbers.add(i);
        }

        int arrayXor = 0;

        for (Integer a : A){
            arrayXor = arrayXor ^ a;
        }

        int fullXor = 0;

        for (Integer fa : totalNumbers){
            fullXor = fullXor ^ fa;
        }

        int missingXor = fullXor ^ arrayXor;
        int r_set_bit = missingXor & -missingXor;

        List<Integer> r_set_group = new ArrayList<>();
        List<Integer> r_unset_group = new ArrayList<>();

        for (Integer a : A){

            if( (a & r_set_bit) > 0){
                r_set_group.add(a);
            }
            else {
                r_unset_group.add(a);
            }
        }


        for (Integer a : totalNumbers){

            if( (a & r_set_bit) > 0){
                r_set_group.add(a);
            }
            else {
                r_unset_group.add(a);
            }
        }

        int n1 = 0;
        int n2 = 0;

        for (Integer x : r_set_group){
            n1 = n1 ^ x;
        }

        for (Integer x : r_unset_group){
            n2 = n2 ^ x;
        }

        ArrayList<Integer> ret = new ArrayList<>(2);

        if (n1 > n2){
            ret.add(n2);
            ret.add(n1);
            return ret;
        }

        ret.add(n1);
        ret.add(n2);
        return ret;
    }

}
