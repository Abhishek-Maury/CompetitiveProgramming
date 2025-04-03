package SearchingSorting;

import java.util.ArrayList;
// https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
// brute force Approch ->O(n^2)

public class CountInversions {
    public static int count(int[] arr){
        int count=0;
       for (int i = 0; i < arr.length; i++) {
           for (int j = i+1; j < arr.length; j++) {
            if (i<j && arr[i]>arr[j]) {
                count++;
            }
           }
       }
       return count;
    }

// optimal Approach -> n
    public static int merging(int [] arr,int start,int mid,int end){
       ArrayList<Integer> temp =new ArrayList<>();
       int i=start;
       int j=mid+1;
       int invCount=0;
       while (i<=mid && j<=end) {
        if (arr[i]<=arr[j]) {
            temp.add(arr[i]);
            i++;
        }else{
            temp.add(arr[j]);  
            j++;        
            invCount+=(mid-i+1);
            
            
        }
        while (i<=mid) {
            temp.add(arr[i]);
            i++;
        }
        while (j<=end) {
            temp.add(arr[j]);
            j++;
        }
        for (int idx = 0; idx <temp.size(); idx++) {
            arr[start+idx]=temp.get(idx);
        }
       }
       return invCount; 
    }
    public static int merge(int[] arr,int st,int end){
        if (st<end) {
            int mid=st+(end-st)/2;
            int left=merge(arr, st, mid);
            int right=merge(arr, mid+1, end);
      
            int invcount=merging(arr, st, mid, end);
            return left+right+invcount;
        }
        return 0;
      
    }
    public static void main(String[] args) {
        int[] arr={2, 4, 1, 3, 5};
        // System.out.println(count(arr));
        System.out.println(merge(arr, 0, arr.length-1));
    }
}
