package SearchingSorting;

// https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/

public class CellingInSortedArray {
    // O(N)  -->Time Complexity
    public static int celling(int[] arr,int x){
        int ans=-1;
        for (int i = arr.length-1; i>=0; i--) {
            if (arr[i]>=x) {
                ans=i;
            }
        }
        return ans;    
    }

    // o(Log N) -->Time Complexity
    // Binary search


    public static int ceilSearch(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1, res = -1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] < x)
                lo = mid + 1;      
            
            else { // Potential ceiling found
                res = mid;   
                hi = mid - 1;
            }
        }
        return res;  
    }

    public static void main(String[] args) {
        int[] arr={1, 1, 2, 8, 10, 10, 12, 19};
        int x= 5;
        System.out.println(celling(arr, x));
        System.out.println(ceilSearch(arr, x));
    }
}
