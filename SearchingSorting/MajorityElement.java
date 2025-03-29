package SearchingSorting;

import java.util.HashMap;

public class MajorityElement {
    // https://www.geeksforgeeks.org/majority-element/

    // Q --> Given an array arr. Find the majority element in the array. If no
    // majority exists, return -1. A majority element in an array is an element that
    // appears strictly more than arr.size() / 2 times in the array.

    // Aproach-> The first aproach comes in my mind is using HashMap,Using hashmap i
    // can store the frequency of th elements O(N) time and the numbers freq where
    // math arr.size()/2 I just return the Element And its not present then i will
    // return -1;

    public static int frequ(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) > n / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 1, 3, 5, 1 };
        System.out.println(frequ(arr));
    }
}
