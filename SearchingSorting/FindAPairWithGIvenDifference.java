package SearchingSorting;

import java.util.*;
// https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
import java.util.HashSet;

public class FindAPairWithGIvenDifference {
    // brute force -->O(N^2)

    public static boolean search(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
               if (Math.abs(arr[i]-arr[j])==x) {
                return true;
               } 
            }
        }
        return false;

    }

    // Optimal Approach--> O(n*LogN)
    // step 1 ->Sort the arrry
    // step 2 ->Initialize a while loop

    public static boolean search2(int[] arr, int n) {
        Arrays.sort(arr);

        int size = arr.length;

        int i = 0, j = 1;

        while (i < size && j < size) {
            if (i != j && (arr[j] - arr[i] == n || arr[i] - arr[j] == n)) {
                System.out.print("Pair Found: " +
                        "( " + arr[i] + ", " + arr[j] + " )");
                return true;
            } else if (arr[j] - arr[i] < n)
                j++;
            else
                i++;
        }

        System.out.print("No such pair");
        return false;
    }
// optimal approach -> O(n) Time coplexitiy
    public static boolean search3(int[] arr, int x) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num + x) || set.contains(num - x)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        // int arr[] = { 5, 20, 3, 2, 50, 80 };
        // int diff = 78;
        int arr[] = { 30, 8, 1, 40, 100 };
        int n = -60;
        // int n = arr.length;
        // search(arr, diff, n);
        // search2(arr, n);
        if (search3(arr, n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
