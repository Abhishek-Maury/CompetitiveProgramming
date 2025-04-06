package SearchingSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//  Adobe Amazon Google Microsoft 
// https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
// https://leetcode.com/problems/4sum/description/

public class FourSum {
    public static List<List<Integer>> sum(int[] arr,int target){
        List<List<Integer>> res=new ArrayList<>();
        int n= arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n-3; i++) {
            // skip duplicates
            if(i>0 && arr[i]==arr[i-1]) continue;

            for (int j =i+1; j < n-2; j++) {
                // skip duplicates for j
                if(j>i+1 && arr[j]==arr[j-1]) continue;

                int k=j+1;
                int l=n-1;
                // Two pointer 
                while (k<l) {
                    long total = arr[i]+arr[j]+arr[k]+arr[l];
                    if (total==target) {
                        res.add(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        k++;
                        l--;

                        // duplicates for k and j
                        while (k<l && arr[k]==arr[k-1]) {
                            k++;
                        }
                        while (k<l && arr[l]==arr[l+1]) {
                            l--;
                        }
                    }
                    else if (total<target) {
                        k++;
                    }else{
                        l--;
                    }
                }
                
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={10,11,10,12,11};
        int targrt=43;
        List<List<Integer>> ans = sum(arr, targrt);
        for (List<Integer> v : ans) {
            for (int x : v) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
