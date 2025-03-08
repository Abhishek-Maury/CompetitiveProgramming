package array;
// https://leetcode.com/problems/contains-duplicate/description/

import java.util.Arrays;
import java.util.HashMap;

public class Duplicates {
    public static boolean containsDuplicates(int[] nums){
        // for (int i = 0; i < nums.length-1; i++) {              complexity O(n^2)
        //     for (int j = i+1; j < nums.length; j++) {
        //         if (nums[i]==nums[j]) {
        //             return true;
        //         }
        //     }
        // }
        // return false;

        // approach 2
        int n=nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {   //complexity O(n*Logn)
            if (nums[i]==nums[i-1]) {
                return true;
            }
        }
        return false;
    }

    // Approach 3 is 0(n)   hashset approach 0(1)
        public static boolean containDuplicate(int[] arr){
        HashMap<Integer,Integer> seen =new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val =arr[i];
            if (seen.containsKey(val)) {
                return true;
            }
            seen.put(val, i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums={1,2,2,3};
        System.out.println(containsDuplicates(nums));
        System.out.println(containDuplicate(nums));

    }
}
