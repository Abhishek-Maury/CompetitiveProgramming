package array;

import java.util.HashSet;

// https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/?ref=lbp

public class PairSumRotatedArray {
   public static boolean pairInSortedRotated(int[] arr, int target){
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
        int complement=target-arr[i];
        if (set.contains(complement)) {
            return true;
        }
        set.add(arr[i]);
    }
    return false;
   }
    public static void main(String[] args) {
        int[] arr={11,15,6,8,9,10};
        if (pairInSortedRotated(arr, 16)) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
