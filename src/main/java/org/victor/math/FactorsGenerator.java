package org.victor.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Interview Preparation Problem :: Generator all the Factor.

 * Scaler problem :: Given an integer A, you need to find the count of it's factors.
 * Factor of a number is the number which divides it perfectly leaving no remainder.
 * Example : 1, 2, 3, 6 are factors of 6

 * */

public class FactorsGenerator {

    public List<Integer> getFactors(int num){

        if (num == 0) return new ArrayList<>();

        List<Integer> factorList = new ArrayList<>();

        for (int i = 1; i * i <= num; i++){

            if (num % i == 0 && i * i < num){
                int factorPair = num / i;
                factorList.add(i);
                factorList.add(factorPair);
            }
            else if (num % i == 0 && i * i == num) {
                factorList.add(i);
            }

        } return factorList;
    }
}



