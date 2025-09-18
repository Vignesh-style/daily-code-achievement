package org.victor.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Scaler problem :: Given an array of integers A.

 * The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
 * Calculate and return the sum of values of all possible subarrays of A modulo 109+7.

 * */

public class MinMaxOfSubArraySum {

    public int solve(ArrayList<Integer> A) {

        List<Integer> left = getNearestGreaterListByIdxOnLeft(A);

        List<Integer> right = getNearestGreaterListByIdxOnRight(A);

        List<Integer> leftS = getNearestSmallerListByIdxOnLeft(A);

        List<Integer> rightS = getNearestSmallerListByIdxOnRight(A);

        // System.out.println(left);
        // System.out.println(right);
        // System.out.println(leftS);
        // System.out.println(rightS);


        int ans = 0;

        int mod = 1000000007;

        for (int i = 0; i < A.size(); i++){

            Integer l = left.get(i);
            Integer r = right.get(i);


            Integer ls = leftS.get(i);
            Integer rs = rightS.get(i);



            // Integer subArrayMax = ( (i - l) * (r - i) % mod ) ;

            // Integer subArrayMin = ( (i - ls) * (rs - i) % mod ) ;

            // Integer diff = subArrayMax - subArrayMin;


            // Long temp = ( 1L * ( diff * A.get(i)));

            //   System.out.println("contribute " + A.get(i) + " - " + diff + " " + " in sum " + temp );

            // ans = ( (int) ( ans + temp % mod) % mod);



            long subArrayMax = ((1L * (i - l) * (r - i)) % mod);

            long subArrayMin = ((1L * (i - ls) * (rs - i)) % mod);

            long diff = (subArrayMax - subArrayMin + mod) % mod; // Ensure positive difference

            long temp = (1L * diff * A.get(i)) % mod;

            ans = (int) ((ans + temp) % mod);

        }

        return ans;

    }

    private static List<Integer> getNearestGreaterListByIdxOnLeft(ArrayList<Integer> A){

        List<Integer> ret = new ArrayList<>();

        Stack<Integer> smallStack = new Stack<>();

        for (int i = 0; i < A.size(); i++){


            while (!smallStack.isEmpty() && A.get(smallStack.peek()) < A.get(i)){
                smallStack.pop();
            }

            if (smallStack.isEmpty()) ret.add(-1);

            else ret.add(smallStack.peek());

            smallStack.push(i);

        }

        return ret;
    }

    private static List<Integer> getNearestGreaterListByIdxOnRight(ArrayList<Integer> A){

        List<Integer> ret = new ArrayList<>(A);

        Stack<Integer> smallStack = new Stack<>();

        int n = A.size();

        for (int i = n-1; i >= 0; i--){


            while (!smallStack.isEmpty() && A.get(smallStack.peek()) <= A.get(i)){
                smallStack.pop();
            }

            if (smallStack.isEmpty()) ret.set(i,n);

            else ret.set(i,smallStack.peek());

            smallStack.push(i);

        }

        return ret;
    }

    private static List<Integer> getNearestSmallerListByIdxOnLeft(ArrayList<Integer> A){

        List<Integer> ret = new ArrayList<>();

        Stack<Integer> smallStack = new Stack<>();

        for (int i = 0; i < A.size(); i++){


            while (!smallStack.isEmpty() && A.get(smallStack.peek()) > A.get(i)){
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
