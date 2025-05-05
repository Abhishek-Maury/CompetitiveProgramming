package StackandQueue;
import java.util.*;

public class RerverseFirstKOfQueue {

    public static Queue<Integer> reverseK(Queue<Integer> q,int k){
        Stack<Integer> s=new Stack<>();
        if (q.isEmpty() || q.size()<k) {
            return q;
        }
        for (int i = 0; i < k && !q.isEmpty(); i++) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        for (int i = 0; i <q.size()-k; i++) {
            q.add(q.remove());
        }
        return q;
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        int k=7;
        reverseK(q, k);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
