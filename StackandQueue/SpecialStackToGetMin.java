package StackandQueue;

import java.util.*;

public class SpecialStackToGetMin {
    static class SpecialStack {
        static Stack<Integer> s = new Stack<>();
        static Stack<Integer> minStack = new Stack<>();

        public static boolean isEmpty() {
            return s.isEmpty();
        }

        public static void push(int data) {
            s.push(data);
            if (minStack.isEmpty() || data <= minStack.peek()) {
                minStack.push(data);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public static int pop(){
            if (s.isEmpty()) {
                return -1;
            }
            int popedElement = s.pop();
            minStack.pop();
            return popedElement;
        }

        public static int peek(){
            if (s.isEmpty()) {
                return -1;
            }
            return s.peek();
        }

        public static int getMin(){
            if (minStack.isEmpty()) {
                return -1;
            }
            return minStack.peek();
        }

    }

    public static void main(String[] args) {
        SpecialStack stack=new SpecialStack();
        stack.push(18);
        stack.push(19);
        stack.push(29);
        stack.push(15);
        stack.push(16);

        System.out.println(stack.getMin());
    }
}
