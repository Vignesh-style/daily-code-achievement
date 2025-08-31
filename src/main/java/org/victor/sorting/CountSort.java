package org.victor.sorting;

import java.util.ArrayList;

/**
 * ScalerProblem ::
 * An integer is given to you in the form of an array, with each element being a separate digit.
 * Find the smallest number (leading zeroes are allowed) that can be formed by rearranging the digits of the given number in an array. Return the smallest number in the form an array.
 * Note - Do not use any sorting algorithm or library's sort method.
 * */

public class CountSort {

    public ArrayList<Integer> smallestNumber(ArrayList<Integer> A) {

        ArrayList<Integer> ret = new ArrayList<>();

        int[] arr =  new int[10];

        for (Integer a : A) arr[a]++;

        for (int i = 0; i < 10; i++){

            int size = arr[i];

            for (int j = 0; j < size; j++){
                ret.add(i);
            }

        }
        return ret;
    }
}
