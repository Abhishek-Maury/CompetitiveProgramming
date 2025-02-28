package array;
// https://leetcode.com/problems/contains-duplicate/description/

import java.util.Arrays;

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
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(containsDuplicates(nums));

    }
}
