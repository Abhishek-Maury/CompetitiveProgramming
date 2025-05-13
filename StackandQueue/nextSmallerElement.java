package StackandQueue;
import java.util.*;

public class nextSmallerElement {
    
    public static ArrayList<Integer> smaller(int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(-1);
        }
        for (int i = arr.length-1; i >=0; i--) {
            while (!s.isEmpty() && arr[s.peek()]>=arr[i]) {
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
        int[] arr={4,8,5,2,25};
        ArrayList<Integer> result =smaller(arr);
        System.out.println(result);
    }
}
