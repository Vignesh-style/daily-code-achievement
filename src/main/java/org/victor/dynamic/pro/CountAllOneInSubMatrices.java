package org.victor.dynamic.pro;

/**
 * LeetCode Problem : : 1504
 * Given an m x n binary matrix mat, return the number of submatrices that have all ones.
 * */

public class CountAllOneInSubMatrices {

    public int count(int[][] mat) {

        int n = mat[0].length;
        int m = mat.length;

        int[][] height = new int[m][n];
        int[][] dp = new int[m][n];

        int total = 0;

        for (int i = 0; i < m; i++){

            for (int j = 0; j < n; j++){

                if (mat[i][j] == 1){

                    height[i][j] =  (i == 0 ? 0 : height[i - 1][j]) + 1;

                    int minHeight = height[i][j];

                    for (int k = j; k >= 0 && mat[i][k] == 1; k--){
                        minHeight = Math.min(height[i][k], minHeight);
                        dp[i][j] += minHeight;
                    }

                    total += dp[i][j];
                }

            }

        }
        return total;
    }
}


/* Height[][] is the key feature in the computation it tells use the column wise taller rectangle
*  we can build when we start traveling on the left, i.e. increasing the width of the rectangle width*/