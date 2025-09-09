package org.victor.array;

import java.util.ArrayList;

public class MedianOfTwoSortedArray {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        ArrayList<Integer> ret = new ArrayList<>();

        int aIdx = 0;
        int bIdx = 0;

        while (aIdx < A.size() && bIdx < B.size()){

            if (A.get(aIdx) <= B.get(bIdx)){
                ret.add(A.get(aIdx));
                aIdx++;
            }

            else {
                ret.add(B.get(bIdx));
                bIdx++;
            }
        }

        while (aIdx < A.size()){
            ret.add(A.get(aIdx));
            aIdx++;
        }

        while (bIdx < B.size()){
            ret.add(B.get(bIdx));
            bIdx++;
        }

        // System.out.println(ret);

        int n = ret.size();
        int m = (n / 2) - 1;

        if (n % 2 == 0) return (ret.get(n/2) + ret.get(m)) / 2;
        else return ret.get(n/2);
    }
}
