package array;

public class NextPerumutation {
    public static void nextpermu(int[] arr) {
        // step 1 find the pivot -->arr[i]<arr[i+1]
        int pivot = -1;
        int rme = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // if pivot not exist
        if (pivot == -1) {
            reverse(arr, 0);
        } else {

            // step 2 find the right most element swap
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > arr[pivot]) {
                    rme = i;
                    break;
                }
            }
            swap(arr, pivot, rme);

            // step 3 reverse decreas order
            reverse(arr, pivot + 1);
        }
    }

    public static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length-1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 6, 5, 4 };
        nextpermu(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
