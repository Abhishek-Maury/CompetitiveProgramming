package SearchingSorting;

// https://www.geeksforgeeks.org/counting-sort/
public class CountSort {
    public static int[] countingSort(int[] arr){
        int n=arr.length;
        int M=0;
        for (int i = 0; i < arr.length; i++) {
            M=Math.max(M, arr[i]);
        }
        int [] countArray = new int[M+1];
        for (int i = 0; i < n; i++) {
            countArray[arr[i]]++;
        }

        for (int i = 1; i <=M; i++) {
            countArray[i]+=countArray[i-1];
        }

        int[] outputArr=new int[n];
        for (int i = n-1; i>=0; i--) {
            outputArr[countArray[arr[i]]-1]=arr[i];
            countArray[arr[i]]--;
        }
        return outputArr;
    }
    public static void main(String[] args) {
        int[] arr ={2,5,3,0,2,3,0,3};
        int[] output= countingSort(arr);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]+" ");
        }
    }
}
