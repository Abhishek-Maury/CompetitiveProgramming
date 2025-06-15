package Heaps;

import java.util.PriorityQueue;

 class kthLargestElementInAStream {
     PriorityQueue<Integer> pq=new PriorityQueue<>();
    int size;

    public kthLargestElementInAStream(int k, int[] nums) {
        size=k;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
    }
    
    public int add(int val) {
        pq.add(val);
         if(pq.size()>size){
                pq.poll();
            }
            return pq.peek();
    }
    public static void main(String[] args) {
        
    }
}
