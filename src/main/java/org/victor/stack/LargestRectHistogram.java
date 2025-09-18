package org.victor.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Scaler problem :: Given an array of integers A.
 * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
 * Find the area of the largest rectangle formed by the histogram.
 * */

public class LargestRectHistogram {

    public int largestRectangleArea(ArrayList<Integer> A) {

        List<Integer> left = getNearestSmallerListByIdxOnLeft(A);
        List<Integer> right = getNearestSmallerListByIdxOnRight(A);


        int ans = -1;

        for (int i = 0 ; i < A.size(); i++){

            int x = left.get(i);
            int x1 = right.get(i);

            Integer temp = ((x1 - x ) - 1) * A.get(i);
            ans = Math.max(temp, ans);

        }

        return ans;
    }


    private static List<Integer> getNearestSmallerListByIdxOnLeft(ArrayList<Integer> A){

        List<Integer> ret = new ArrayList<>();

        Stack<Integer> smallStack = new Stack<>();

        for (int i = 0; i < A.size(); i++){

            while (!smallStack.isEmpty() && A.get(smallStack.peek()) >= A.get(i)){
                smallStack.pop();
            }

            if (smallStack.isEmpty()) ret.add(-1);

            else ret.add(smallStack.peek());

            smallStack.push(i);

        }
        return ret;
    }

    private static List<Integer> getNearestSmallerListByIdxOnRight(ArrayList<Integer> A){

        List<Integer> ret = new ArrayList<>(A);

        Stack<Integer> smallStack = new Stack<>();

        int n = A.size();

        for (int i = n-1; i >= 0; i--){

            while (!smallStack.isEmpty() && A.get(smallStack.peek()) >= A.get(i)){
                smallStack.pop();
            }

            if (smallStack.isEmpty()) ret.set(i,n);

            else ret.set(i,smallStack.peek());

            smallStack.push(i);

        }
        return ret;
    }
}
