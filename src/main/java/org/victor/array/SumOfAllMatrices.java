package org.victor.array;

import java.util.ArrayList;

/**
 * Scaler :: Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
 * */

public class SumOfAllMatrices {

    public int computeSum(ArrayList<ArrayList<Integer>> A) {

        int N = A.size();
        int totalSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                int topLeftCount = (i + 1) * (j + 1);
                int bottomRightCount = (N - i) * (N - j);
                int contribution = topLeftCount * bottomRightCount * A.get(i).get(j);
                totalSum += contribution;
            }
        }

        return totalSum;
    }

}
