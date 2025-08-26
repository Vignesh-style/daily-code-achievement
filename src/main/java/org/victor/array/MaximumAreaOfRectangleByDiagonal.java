package org.victor.array;

/**
 * LeetCode Problem :: 3000.
 You are given a 2D 0-indexed integer array dimensions.
 For all indices i, 0 <= i < dimensions.length, dimensions[i][0] represents the length and dimensions[i][1] represents the width of the rectangle i.
 Return the area of the rectangle having the longest diagonal. If there are multiple rectangles with the longest diagonal, return the area of the rectangle having the maximum area.
 * */

public class MaximumAreaOfRectangleByDiagonal {

    public int areaOfMaxDiagonal(int[][] dimensions) {

        int maxArea = Integer.MIN_VALUE;
        int maxDiagonal = Integer.MIN_VALUE;

        for (int[] row : dimensions){

            int length = row[0];
            int width = row[1];
            int currArea = length * width;
            int currDiagonalSquared = length * length + width * width;

            if (currDiagonalSquared > maxDiagonal) {
                maxDiagonal = currDiagonalSquared;
                maxArea = currArea;
            } else if (currDiagonalSquared == maxDiagonal) {
                maxArea = Math.max(maxArea, currArea);
            }
        }
        return maxArea;
    }
}
