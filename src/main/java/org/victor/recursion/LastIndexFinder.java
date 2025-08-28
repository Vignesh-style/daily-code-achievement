package org.victor.recursion;

import java.util.ArrayList;

/**
 * Scaler problem :: You are given an array A of size N. Write a recursive function that returns the last index at which an integer B is found in the array.
 * NOTE: If B is not found anywhere in the array, then return -1.
 * */

public class LastIndexFinder {

    public int LastIndex(ArrayList<Integer> A, int B) {

        ArrayList<Integer> ret = new ArrayList<>();
        findTargetPosition(A, B, 0, ret);

        if (ret.isEmpty()) return -1;
        return ret.getLast();
    }


    public void findTargetPosition(ArrayList<Integer> list, int target, int idx, ArrayList<Integer> ret){

        if (list.size() == idx) return;

        if (list.get(idx) == target) ret.add(idx);

        findTargetPosition(list, target, idx + 1, ret);

    }

}
