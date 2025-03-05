package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Two pointer methodh

public class ThirdSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            if (i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int j=i+1;
            int k=n-1;
            while (j<k) {
                int sum=nums[i]+nums[j]+nums[k];
                if (sum<0) {
                   j++; 
                }else if (sum>0) {
                    k--;
                }else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while (j<k && nums[j]==nums[j-1]) {
                        j++;
                    }
                    while (j<k && nums[k]==nums[k+1]) {
                        k--;
                    }
                }
            }
        }
        return ans; 
    }
    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,4};
        
    }
}
