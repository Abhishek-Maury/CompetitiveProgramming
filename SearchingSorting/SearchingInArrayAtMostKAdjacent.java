package SearchingSorting;

public class SearchingInArrayAtMostKAdjacent {

    // https://www.geeksforgeeks.org/searching-array-adjacent-differ-k/
    public static int search(int[] arr, int n, int x, int k) {
        int i = 0;
        while (i < n) {
            if (arr[i] == x) {
                return i;
            }
            i = i + Math.max(1, Math.abs(arr[i] - x) / k);
        }

        System.out.println("number is " +
                "not present!");
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 20, 40, 50, 70, 70, 60 };
        int n = arr.length;
        int k = 20;
        int x = 60;
        System.out.println("Element "+x +" present in index "+search(arr, n, x, k));
    }
}
