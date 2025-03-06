package array;

import java.util.Collections;
import java.util.PriorityQueue;
// https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1+

public class KthSmallest {
    public static int kthSmallest(int[] arr, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for (int i = 0; i < k; i++) {
        pq.add(arr[i]);
       }
       for (int i = k; i < arr.length; i++) {
        if (pq.peek()>arr[i]) {
            pq.poll();
            pq.add(arr[i]);
        }
       }
       return pq.peek();
    }
    public static void main(String[] args) {
        int [] arr={7,10,4,3,20,15};
        System.out.println(kthSmallest(arr, 3));
    }
}
