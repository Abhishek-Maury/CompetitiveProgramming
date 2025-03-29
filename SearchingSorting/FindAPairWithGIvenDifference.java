package SearchingSorting;

import java.util.Arrays;
// https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/

public class FindAPairWithGIvenDifference {
    // brute force -->O(N^2)

    public static void search(int[] arr, int diff, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if ((arr[j] - arr[i]) == diff) {
                    System.out.println("(" + arr[i] + "," + arr[j] + ")");
                    return;
                }
            }

        }
        System.out.println("No such pair find");

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

    public static void main(String[] args) {
        // int arr[] = { 5, 20, 3, 2, 50, 80 };
        // int diff = 78;
        int arr[] = {30, 8, 1, 40, 100};
        int n = -60;
        // int n = arr.length;
        // search(arr, diff, n);
        search2(arr, n);

    }
}
