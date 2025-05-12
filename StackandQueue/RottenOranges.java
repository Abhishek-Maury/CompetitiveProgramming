package StackandQueue;

import java.util.*;

public class RottenOranges {
    static class Node {
        int row;
        int col;
        int time;

        public Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int orange(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Node> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntfresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    cntfresh++;
                }
            }
        }

        int tm = 0;
        int[] delrow = { -1, 0, +1, 0 };
        int[] delcol = { 0, -1, 0, +1 };
        int cnt = 0;

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            tm = Math.max(t, tm);
            q.remove()
            for (int i = 0; i < 4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1) {
                    q.add(new Node(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }

            }
        }
        if (cntfresh != cnt) {
            return -1;
        }
        return tm;

    }

    

    public static void main(String[] args) {
        int[][] arr = {
                { 0, 1, 2 },
                { 0, 1, 1 },
                { 2, 1, 1 }
        };
        System.out.println(orange(arr));
    }
}
