package StackandQueue;
import java.util.*;

public class NextGreaterElement {
    public static ArrayList<Integer> nge(int[] arr){
        Stack<Integer> s=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(-1);
        }
       for (int i = arr.length-1; i >=0; i--) {
           while(!s.isEmpty() && arr[s.peek()]<=arr[i]) {
              s.pop();
           }
           if (!s.isEmpty()) {
             list.set(i, arr[s.peek()]);
           }
           s.push(i);
       }
       return list;
    }
    public static void main(String[] args) {
        int[] arr={1,3,2,4};
        nge(arr);

    }
}
