package array;

// https://leetcode.com/problems/maximum-subarray/description/
public class MaxSubarray {
    public static int maxo(int[] nums){
        int sum=0;
        int max=nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            max=(sum>max) ?sum:max;
            if (sum<0) {
                sum=0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums={5,4,-1,7,8};
        System.out.println(maxo(nums));
    }
}
