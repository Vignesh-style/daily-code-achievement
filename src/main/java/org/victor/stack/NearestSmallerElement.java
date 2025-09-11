package org.victor.stack;

import java.util.Stack;

/**
 * Scaler problem :: Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
 * More formally,
 * G[i] for an element A[i] = an element A[j] such that j is maximum possible
  AND
 * j < i
  AND
 * A[j] < A[i]

 * Elements for which no smaller element exist, consider the next smaller element as -1.

 Problem Constraints
 1 <= |A| <= 100000
 -109 <= A[i] <= 109

 * */



public class NearestSmallerElement {

    public int[] prevSmaller(int[] A) {

        int[] nse = new int[A.length];
        Stack<Integer> minStack = new Stack<>();

        for (int i = 0; i < A.length; i++) {

            int curr_element = A[i];

            while (!minStack.isEmpty() && minStack.peek() >= curr_element){
                minStack.pop();
            }

            if (minStack.isEmpty()) {
                nse[i] = -1;
            }
            else {
                nse[i] = minStack.peek();
            }

            minStack.push(curr_element);
        }
        System.out.println(minStack);
        return nse;
    }
}


/**
 * Understanding sample :
 *
 * input :: [4,5,2,6,8]
 * output :: [-1,4,-1,2,6].  \/ in the stack we will have {2 -> 6 -> 8} in the end.
 * */