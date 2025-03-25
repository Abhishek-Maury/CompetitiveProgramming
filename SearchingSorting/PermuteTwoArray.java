package SearchingSorting;

import java.util.*;
// https://www.geeksforgeeks.org/permute-two-arrays-sum-every-pair-greater-equal-k/

public class PermuteTwoArray {
    public static Boolean suchArray(Integer[] a, int[] b,int k){
        Arrays.sort(a,Collections.reverseOrder());
        Arrays.sort(b);

        for (int i = 0; i < b.length; i++) {
            if (a[i]+b[i]<k) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Integer[] a = {2,1,3};
        int[] b = {8,7,9};
        int k=10;
        if (suchArray(a, b, k)) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
