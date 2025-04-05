package SearchingSorting;

import java.util.Arrays;

public class CheckIfReversingaSubArrayMakeThearraySorted {
// brute force -> O(n*logn) 

    public static boolean reverse(int[] arr){
        int n =arr.length;
        int[] temp=new int[n];
        for (int i = 0; i < n; i++) {
            temp[i]=arr[i];
        }
        Arrays.sort(temp);
        int front;
        for ( front = 0; front < n; front++) {
            if (temp[front]!=arr[front]) {
                break;
            }
        }
        int back;
        for ( back = n-1; back>=0; back--) {
            if (temp[back]!=arr[back]) {
                break;
            }
        }

        do {
           front++;
           if (arr[front-1]<arr[front]) {
            return false;
           } 
        } while (front!=back);
        return true;
    }

// optimal Approach -> O(N)
   public static void reverse2(int[] a,int x,int y) 
    { 
      while(x<y) 
      { 
        int temp = a[x]; 
        a[x] = a[y]; 
        a[y] = temp; 
        x++; 
        y--; 
      } 
    } 
  public  static boolean sortArr(int[] a, int n) 
    { 
      int x = -1; 
      int y = -1; 
    
      for (int i = 0; i < n - 1; i++) { 
        if (a[i] > a[i + 1]) { 
          if (x == -1) { 
            x = i; 
          } 
          y = i + 1; 
        } 
      } 
    
      if (x != -1) { 
        reverse2(a,x,y); 
        for (int i = 0; i < n - 1; i++) { 
          if (a[i] > a[i + 1]) { 
            return false; 
          } 
        } 
      } 
    
      return true; 
    } 
    public static void main(String[] args) {
        int[] arr={1,2,5,4,3};
        if (sortArr(arr, arr.length)) {
            System.out.println("Yes");
        }else{
            System.out.println("N");
        }

    }
}
