package array;

public class RemoveDuplicates {

    public static int remove(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2 };
        System.out.println(remove(arr));
    }
}
