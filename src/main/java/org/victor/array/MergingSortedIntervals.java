package org.victor.array;

import java.util.ArrayList;

/**
 * Scaler Problem :: You are given a collection of intervals A in a 2-D array format, where each interval is represented by a pair of integers `[start, end]`.
 * The intervals are sorted based on their start values.
 * Your task is to merge all overlapping intervals and return the resulting set of non-overlapping intervals.
 * */

public class MergingSortedIntervals {

    public static ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> A) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        if (A == null || A.isEmpty()) return ret;

        ArrayList<Integer> result = A.getFirst();

        for (int i = 1; i < A.size(); i++)
        {
            Integer temp = A.get(i).get(0);

            if (result.get(0) <= temp && temp <= result.get(1))
                result.set(1, Math.max(result.get(1), A.get(i).get(1)));

            else {
                ret.add(result);
                result = A.get(i);
            }
        }

        ret.add(result);
        return ret;
    }
}
