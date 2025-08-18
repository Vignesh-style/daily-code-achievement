package org.victor.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  HackerRank.
 *  Detailed view of question in the resources : red-knights-shortest-path-English.pdf
 * */

public class RedKnightShortestPath {

    public static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {

        // Print the distance along with the sequence of moves.
        if (i_start == i_end && j_start == j_end) {
            System.out.println(0);
            return;
        }

        String[] moveNames = {"UL", "UR", "R", "LR", "LL", "L"};
        int[][] directions = {{-2,-1},{-2,1},{0,2},{2,1},{2,-1},{0,-2}};

        boolean ans = false;

        boolean[][] visited = new boolean[n][n];

        Queue<IndexPath> q = new LinkedList<>();

        //forming the first start co-ord
        IndexPath idxP1 = new IndexPath(i_start, j_start, 0, new ArrayList<>());
        q.add(idxP1);

        visited[i_start][j_start] = true;


        while (!q.isEmpty()){

            IndexPath currentIP = q.poll();

            if (currentIP.i_cord == i_end && currentIP.j_cord == j_end){
                ans = true;
                System.out.println(currentIP.path_length);
                for (String s : currentIP.pathSoFar){
                    System.out.print(s + " ");
                }
                break;
            }


            for (int i = 0; i < directions.length; i++){

                int[] direction = directions[i];

                int future_i = currentIP.i_cord + direction[0];
                int future_j = currentIP.j_cord + direction[1];
                int future_path = currentIP.path_length + 1;

                //is a valid future_path
                if (future_i >= 0 && future_j >= 0 && future_i < n && future_j < n &&
                        !visited[future_i][future_j]){

                    visited[future_i][future_j] = true;

                    List<String> newPath = new ArrayList<>(currentIP.pathSoFar);
                    newPath.add(moveNames[i]);
                    IndexPath futureIP  = new IndexPath(future_i, future_j, future_path, newPath);
                    q.add(futureIP);

                }

            }

        }

        if (!ans)
            System.out.println("Impossible");

    }

    public static class IndexPath {
        int i_cord;
        int j_cord;
        int path_length;
        List<String> pathSoFar = new ArrayList<>();

        public IndexPath(int i_cord, int j_cord, int path_length, List<String> list){
            this.i_cord = i_cord;
            this.j_cord = j_cord;
            this.path_length = path_length;
            this.pathSoFar = list;
        }
    }
}
