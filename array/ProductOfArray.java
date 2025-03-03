package array;

import java.util.Arrays;

public class ProductOfArray {
    public static int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        // prefix
        for (int i = 1; i < n; i++) {
            ans[i]=ans[i-1]*nums[i-1];
        }
        int suffix=1;
        for (int i = n-2; i >=0; i--) {
            suffix*=nums[i+1];
            ans[i]*=suffix;
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] nums={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }
}
