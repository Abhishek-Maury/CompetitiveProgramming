package array;



// https://leetcode.com/problems/search-in-rotated-sorted-array

public class SearchRotatedArray {
    public static int search(int[] arr,int target){
        int start=0;
        int end=arr.length-1;

        while (start<=end) {
            int mid = start+(end-start)/2;
            if (target==arr[mid]) {
                return mid;
            }else if (arr[start]<=arr[mid]) {
                if (target>=arr[start] && target<=arr[mid]) {
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if (target>=arr[mid] && target<=arr[end]) {
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr ={5,6,7,8,9,1,2,3};
        System.out.println(search(arr,9));
    }
}
