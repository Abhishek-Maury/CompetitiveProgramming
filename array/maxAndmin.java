package array;

// https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

public class maxAndmin {
    public static int max(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    public static int min(int[] arr){
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<ans) {
                ans=arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 4, 1, 9 };
        System.out.println("maximum element is :" + max(arr));
        System.out.println("minimum element is :" + min(arr));
    }
}