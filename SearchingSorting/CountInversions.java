package SearchingSorting;

import java.util.ArrayList;

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
            invCount+=(mid-i+1);
            j++;
            
        }
        while (i<=mid) {
            temp.add(arr[i]);
            i++;
        }
        while (j<=end) {
            temp.add(arr[j]);
            j++;
        }
        for (int idx = 0; idx <= end; idx++) {
            arr[idx]=temp.get(i-start);
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
        int[] arr={5, 4, 3, 2, 1};
        // System.out.println(count(arr));
        System.out.println(merge(arr, 0, arr.length-1));
    }
}
