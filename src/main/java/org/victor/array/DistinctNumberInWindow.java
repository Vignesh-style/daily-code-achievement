package org.victor.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Scaler Problem :: You are given an array of N integers, A1, A2 ,..., AN and an integer B.
 * Return the of count of distinct numbers in all windows of size B.
 * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 * NOTE: if B > N, return an empty array.
 * */

public class DistinctNumberInWindow {

    public ArrayList<Integer> dNums(ArrayList<Integer> arr, int windowSize) {

        Map<Integer, Integer> sizeMap = new HashMap<>();
        int uniqueCount = 0;
        ArrayList<Integer> ret = new ArrayList<>();

        if (windowSize > arr.size()) return ret;


        for (int i = 0; i < windowSize; i++) {

            if (sizeMap.containsKey(arr.get(i))){

                sizeMap.put(arr.get(i), sizeMap.get(arr.get(i)) + 1);

            } else {
                sizeMap.put(arr.get(i) , 1);
                uniqueCount++;
            }


        }

        ret.add(uniqueCount);

        int left = 0;
        int right = windowSize;

        while (right < arr.size()){

            Integer outgoing = arr.get(left);
            sizeMap.put(outgoing, sizeMap.get(outgoing) - 1);

            if (sizeMap.get(outgoing) == 0){
                uniqueCount--;
                sizeMap.remove(outgoing);
            }


            Integer incoming = arr.get(right);
            sizeMap.put(incoming, sizeMap.getOrDefault(incoming, 0) + 1);

            if (sizeMap.get(incoming) == 1) uniqueCount++;

            ret.add(uniqueCount);
            left++;
            right++;

        }
        return ret;
    }

}
