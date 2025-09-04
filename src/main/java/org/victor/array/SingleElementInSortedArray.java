package org.victor.array;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Scaler problem :: Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
 * Elements which are appearing twice are adjacent to each other.
 * NOTE: Users are expected to solve this in O(log(N)) time.
 * */

public class SingleElementInSortedArray {

    public int solve(ArrayList<Integer> A) {

        int high = A.size() - 1;
        int low = 0;

        while (low <= high){

            // System.out.println(low);
            // System.out.println(high);

            int mid = low + (high - low) / 2;

            Integer res = computePairStatusWithStartingIdx(mid, A);

            if (res == 0){
                return A.get(mid);
            }
            else if (res == 1){
                low = mid + 1;
            }
            else if (res == -1){
                high = mid - 1;
            }

        }
        return -1;
    }

    private Integer computePairStatusWithStartingIdx(int idx, ArrayList<Integer> list){

        Integer mid = list.get(idx);
        int lIdx = (idx == 0) ? idx : idx - 1;
        Integer lValue =  list.get(lIdx);
        int rIdx = (idx == list.size() - 1) ? idx : idx + 1;
        Integer rValue = list.get(rIdx);

        if (Objects.equals(lIdx, idx) || Objects.equals(rIdx, idx)){
            return 0;
        }

        // System.out.println(mid);
        // System.out.println(lValue);
        // System.out.println(rValue);
        // System.out.println("idx");
        // System.out.println(idx);
        // System.out.println(lIdx);
        // System.out.println(rIdx);

        // System.out.println("-------------");

        if (!Objects.equals(lValue,mid) && !Objects.equals(rValue,mid)){
            return 0;
        }

        else if (Objects.equals(lValue,mid) && !Objects.equals(rValue,mid)){

            if ((lIdx) % 2 == 0){
                return 1;
            } else {
                return -1;
            }

        }

        else if (!Objects.equals(lValue,mid) && Objects.equals(rValue,mid)){

            if ((idx) % 2 == 0){
                return 1;
            } else {
                return -1;
            }

        }

        return null;
    }
}
