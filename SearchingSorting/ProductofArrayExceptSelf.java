package SearchingSorting;

import java.util.Arrays;

// https://www.geeksforgeeks.org/a-product-array-puzzle/
public class ProductofArrayExceptSelf {
    public static int[] product(int[] arr){
        int n= arr.length;
        int[] res =new int[n];
        Arrays.fill(res, 1);
        for (int i = 0; i < res.length; i++) {           
            for (int j = 0; j < res.length; j++) {
                if (i!=j) {
                    res[i]*=arr[j];
                }
               
            }
        }
        return res;
    }
    public static int[] product2(int[] arr){
        int n= arr.length;
        int[] ans=new int[n];
        int[] pre=new int[n];
        int [] suff = new int[n];
       pre[0]=1;
       suff[n-1]=1;
       //prefix
       for (int i = 1; i < suff.length; i++) {
        pre[i]=pre[i-1]*arr[i-1];
       }

    //    suffix
    for (int i = n-2; i >=0; i--) {
        suff[i]=suff[i+1]*arr[i+1];
    }
    for (int i = 0; i < n; i++) {
        ans[i]=pre[i]*suff[i];
    }
    return ans;
    }
    public static void main(String[] args) {
        int[] arr={10,3,5,6,2};
        System.out.println(Arrays.toString(product2(arr)));
    }
}
