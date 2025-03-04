package array;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinRotatedArray {
    public static int findMin(int[] nums) {
        int start=0;
        int end =nums.length-1;
        int min=Integer.MAX_VALUE;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (nums[mid]>=nums[start]) {
                min=Math.min(min, nums[start]);
                start=mid+1;
            }else{
                min=Math.min(min, nums[mid]);
                end=mid-1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        
        int[] arr={3,4,5,1,2};
        System.out.println(findMin(arr));

    }
}
