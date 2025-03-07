package array;

// https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
public class ArrayPalindrome {
    public static int findMinOps(int[] arr,int n){

        int ans=0;
        int i=0;
        int j=n-1;

        while (i<=j) {
            if (arr[i]==arr[j]) {
                i++;
                j--;
            }
            else if (arr[i]>arr[j]) {
                j--;
                arr[j]+=arr[j+1];
                ans++;
            }else{
                i++;
                arr[i]+=arr[i-1];
                ans++;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] arr = {11,14,19,99};
        int n= arr.length;
        System.out.println(findMinOps(arr, n));
    }
}
