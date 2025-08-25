package org.victor.array;

import java.util.ArrayList;

/**
 * Scaler problem :: Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.

 Note :
 If two rows have the maximum number of 1 then return the row which has a lower index.
 Rows are numbered from top to bottom and columns are numbered from left to right.
 Assume 0-based indexing.
 Assume each row to be sorted by values.
 Expected time complexity is O(rows + columns)
 * */

public class RowWithMaxOnes {

    public int rowWithMaxOnes(ArrayList<ArrayList<Integer>> A) {

        int[] arr = new int[2];
        int max = 0;

        for (int i = 0; i < A.size(); i++){

            ArrayList<Integer> inList =  A.get(i);


            if (inList.getFirst() == 0 && inList.getLast() == 0) continue;

            else {

                int zeroCount = 0;

                for (Integer a : inList){

                    if (a == 0) zeroCount++;

                    else break;
                }

                if ( (inList.size() - zeroCount )  > max){
                    arr[0] = i;
                    arr[1] = inList.size() - zeroCount;
                    max = arr[1];
                }
            }

        }
        return arr[0];
    }
}
