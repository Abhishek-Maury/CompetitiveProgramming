package array;

import java.util.HashMap;

public class DuplicatesTwo {
    public static boolean containsDuplicate(int[] arr,int k){
        HashMap<Integer,Integer> seen =new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val =arr[i];
            if (seen.containsKey(val)&& i-seen.get(val)<=k) {
                return true;
            }
            seen.put(val, i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(containsDuplicate(arr, 3));
    }
}
