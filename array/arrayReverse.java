package array;

// https://www.geeksforgeeks.org/program-to-reverse-an-array/
public class arrayReverse {
    public static void reverse(int[] arr){
        int i=0;
        int j=arr.length-1;
        while (i<j) {
            //swap
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        
;
    }
    public static void main(String[] args) {
        int [] arr = {1,4,3,2,6,5};
       reverse(arr);
       for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]+" ");
       }
        
    }
}
