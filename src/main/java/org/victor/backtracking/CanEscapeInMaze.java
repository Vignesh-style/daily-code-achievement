package org.victor.backtracking;

/**
 * {@code CanEscapeInMaze} backtracking basic question -- A rat is in the origin (0,0) return whether it there is any way to reach the target.
 * */

public class CanEscapeInMaze {

    public boolean canYouEscapeMaze(int[][] maze, int start, int end, int target_x, int target_y){

        return helper(maze, start, end, target_x, target_y, new boolean[maze.length][maze[0].length]);
    }

    private boolean helper(int[][] maze, int startX, int startY, int targetX, int targetY, boolean[][] visited) {

        if (startX < 0 || startY < 0 || startX >= maze.length || startY >= maze[0].length) return false;
        if (maze[startX][startY] == 1) return false;
        if (startX == targetX && startY == targetY) return true;

        if (visited[startX][startY]) return false;

        visited[startX][startY] = true;

        int[][] directions = new int[][]{{0,-1}, {0,1}, {1,0}, {-1, 0}}; //4 directions.

        for (int[] direction : directions) {

            int tempX = startX + direction[0];
            int tempY = startY + direction[1];
            return helper(maze, tempX, tempY, targetX, targetY, visited);
        }
        return false;
    }
}
