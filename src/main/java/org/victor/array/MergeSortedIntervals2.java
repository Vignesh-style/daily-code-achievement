package org.victor.array;

import java.util.ArrayList;

/**
 * Scaler problem :: You have a set of non-overlapping intervals.
 * You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.

 * Problem Constraints
 * 0 <= |intervals| <= 10^5
 * */

public class MergeSortedIntervals2 {

    public ArrayList<ArrayList<Integer>> insert(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B) {

        Integer st = B.get(0);
        Integer ed = B.get(1);
        int N = A.size();

        for (int i = 0; i < A.size(); i++){

            if (A.get(i).get(0) <= st && st <= A.get(i).get(1)){
                A.add(i + 1, B);
                break;
            }

            else if (A.get(i).get(0) > B.getFirst()){
                A.add(i, B);
                break;
            }
        }

        if (A.size() == N){
            A.add(B);
        }

        return MergingSortedIntervals.merge(A);
    }
}
