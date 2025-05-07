package StackandQueue;
import java.util.*;

public class StackPermutation {
    public static boolean permu(int[] a,int[] b){
        Stack<Integer> s=new Stack<>();
        int j=0;
        for (int i = 0; i < a.length; i++) {
            s.push(a[i]);
            while (!s.isEmpty() && s.peek().equals(b[j])) {
                s.pop();
                j++;
            }
        }
        return (b.length==j);
    }
    public static void main(String[] args) {
        int []a={1,2,3};
        int[] b={2,1,3};
        System.out.println(permu(a, b));
    }
}
