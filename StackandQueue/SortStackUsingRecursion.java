package StackandQueue;

import java.util.*;

public class SortStackUsingRecursion {
    public static void sortedInserted(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInserted(s, x);
        s.push(temp);
    }

    public static void sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sort(s);
            sortedInserted(s, x);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(11);
        s.push(2);
        s.push(32);
        s.push(3);
        s.push(41);
        sort(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
