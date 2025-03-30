package SearchingSorting;

import java.util.Arrays;

public class CountTripletsSumSmallerThanGivenValue {

    // https://www.geeksforgeeks.org/count-triplets-with-sum-smaller-than-a-given-value/

    //Approach -> brute force
    // O(n^3) time 
    public static int count(int[] arr,int sum){
        int ans=0;
        int n=arr.length;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if (arr[i]+arr[j]+arr[k]<sum) {
                        ans++;
                    }
                }
            }
        }
        return ans;

    }

    // Approach 2 
    public static int coun2(int[] arr,int sum){
        Arrays.sort(arr);
        int ans=0;
        int n=arr.length;
        for (int i = 0; i < n-2; i++) {
            int j=i+1,k=n-1;
            while (j<k) {
                // if the total sum is greater than the sum value then we need to k-- to take 
                // a small value
                if (arr[i]+arr[j]+arr[k]>=sum) {
                    k--;
                }
                // if the total value is less than the sum value then (k-j)th All the value are 
                // less than the sum because it is sorted So j++
                else{
                    ans+=(k-j);
                    j++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {5, 1, 3, 4, 7};
       int sum = 12;
       System.out.println(count(arr, sum));
       System.out.println(coun2(arr, sum));
    }
}
