package StackandQueue;

import java.util.*;

public class DistanceofNearestCellHaving1 {
    static class Node {
        int first;
        int secound;
        int third;

        public Node(int first, int secound, int third) {
            this.first = first;
            this.secound = secound;
            this.third = third;
        }

    }

    public static int[][] grid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] delrow = { -1, 0, +1, 0 };
        int[] delcol = { 0, +1, 0, -1 };

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().secound;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol, steps+1));

                }
            }

        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 0, 1 }
        };
    }
}
