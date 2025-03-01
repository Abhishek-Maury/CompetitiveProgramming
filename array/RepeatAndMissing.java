package array;

// https://www.interviewbit.com/problems/repeat-and-missing-number-array/hints/
import java.util.ArrayList;

public class RepeatAndMissing {
    public static ArrayList<Integer> miss(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n + 1];
        int missing = -1;
        int repeat = -1;
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                missing = i;
            } else if (freq[i] == 2) {
                repeat = i;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeat);
        result.add(missing);
        return result;

    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 6, 2, 1, 1 };
      
        ArrayList<Integer> ans = miss(arr);
        System.out.println(ans.get(0)+" "+ans.get(1));

    }
}
