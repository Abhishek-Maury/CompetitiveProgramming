package array;

import java.util.*;

class Query {
    int L;
    int R;

    Query(int l, int r) {
        this.L = l;
        this.R = r;
    }

}

public class MOsAlgo {
    public static void printQuerySums(int[] arr, int n, ArrayList<Query> q, int m) {
        for (int i = 0; i < m; i++) {
            int L = q.get(i).L, R = q.get(i).R;
            int sum = 0;
            for (int j = L; j <= R; j++) {
                sum += arr[j];
            }
            System.out.println("sum of [" + L + "," + R + "] is " + sum);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 1, 3, 4, 5, 2, 8 };
        int n = arr.length;
        ArrayList<Query> q = new ArrayList<>();
        q.add(new Query(0, 4));
        q.add(new Query(1, 3));
        q.add(new Query(2, 4));
        int m = q.size();
        printQuerySums(arr, n, q, m);

    }
}
