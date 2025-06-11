package Heaps;

import java.util.PriorityQueue;

public class SortANearlyOrKSortedArray {
    public static void nearly(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=arr.length;
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        int i=k;
        for ( i = k; i < n; i++) {
            pq.add(arr[i]);
            arr[i-k]=pq.poll();
        }
        
        while (!pq.isEmpty()) {
            arr[i-k]=pq.poll();
            i++;
        }
    }
    public static void main(String[] args) {
        
    }
}
