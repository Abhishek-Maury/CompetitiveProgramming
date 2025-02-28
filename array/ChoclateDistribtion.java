package array;

import java.util.Arrays;

// https://www.geeksforgeeks.org/chocolate-distribution-problem/

public class ChoclateDistribtion {
    public static int choclateProblem(int[] arr,int m){
        int n=arr.length;
        Arrays.sort(arr);   // 0(nlogn)
        int minDiff=Integer.MAX_VALUE;

        for (int i = 0; i+m-1 < n; i++) {
            int diff=arr[i+m-1]-arr[i];
            if (diff<minDiff) {
                minDiff=diff;
            }
        }
        return minDiff;
    }
    public static void main(String[] args) {
        int arr[]={7,3,2,4,9,12,56};
        System.out.println(choclateProblem(arr, 3));
    }
}
