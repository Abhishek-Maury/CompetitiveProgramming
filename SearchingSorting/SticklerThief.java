package SearchingSorting;

import java.util.Arrays;
// Leetcode(198) House Robber
// https://leetcode.com/problems/house-robber/description/
// https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/

public class SticklerThief {
    public static int loot(int[] arr, int n, int[] dp) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        // Memoization
        int pick = arr[n - 1] + loot(arr, n - 2, dp);
        int notPick = loot(arr, n - 1, dp);

        dp[n]=Math.max(pick, notPick);
        return dp[n];

    }

    
    public static int maxProfit(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
       return loot(arr, n, dp);

    }

    // tabulation

    public static int rob2(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] =Math.max(nums[0], nums[1]); 


        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i - 2]);
        }

        return dp[n-1];        
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 3 };
    //   System.out.println(maxProfit(arr));
    System.out.println(rob2(arr));

    }
}
